package com.vccloud.portal.util;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.log4j.Logger;

import com.sun.crypto.provider.SunJCE;

/**
 * 
 * id protector, protect id's integrity. the program will generate a digest
 * string, together with id. when the browser pass the protected id back to
 * server, we can do the same check.
 * 
 * @author wjxie
 * 
 */
public class IdProtector {

	private static Logger logger = Logger.getLogger(IdProtector.class);

	private IdProtector() {

	}

	private static final String ALGORITHM = "DES";

	private static final String STRING_ENCODING = "ISO-8859-1";

	private static final byte[] keyCodes = { 18, 73, 45, 19, 33, 57, 49, 28,
			110 };
	private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private static SecretKey key = null;
	private static Cipher enCipher = null;
	private static final int SHORT_ARRAY_LENGTH = 8;
	private static final int HEX_STRING_LENGTH = SHORT_ARRAY_LENGTH * 2;
	private static final int ID_TYPE_LENGTH = 2;
	private static final int PROTECTED_ID_MIN_LENGTH = ID_TYPE_LENGTH
			+ HEX_STRING_LENGTH + 1;

	static {
		try {
			Security.addProvider(new SunJCE());
			DESKeySpec dks = new DESKeySpec(keyCodes);
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance(ALGORITHM);
			key = keyFactory.generateSecret(dks);
			enCipher = Cipher.getInstance(ALGORITHM);
			enCipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (Exception e) {
			logger.error("IdProtector init error.", e);
			throw new RuntimeException();
		}
	}

	/**
	 * encrypt input string with DES and return the encrypted byte array.
	 * 
	 * @param info
	 * @return
	 */
	private static byte[] encrypt(String info) {
		try {
			byte[] cipherBytes = enCipher.doFinal(info
					.getBytes(STRING_ENCODING));
			return cipherBytes;
		} catch (Exception e) {
			logger.error("IdProtector encrypt error.", e);
			throw new RuntimeException();
		}
	}

	/**
	 * byte array to hex string. notice that hex string's length is double of
	 * byte array's length.
	 * 
	 * @param bs
	 * @return
	 */
	private static String toHex(byte[] bs) {
		if (bs == null || bs.length == 0) {
			return null;
		}
		int length = bs.length;
		char[] str = new char[length * 2];
		int k = 0;
		for (int i = 0; i < length; i++) {
			byte byte0 = bs[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}

	/**
	 * make a byte array to a fixed size byte array. if the byte array is null,
	 * return null. otherwise always return a fixed size byte array. currently
	 * the fixed size is 8.
	 * 
	 * @param bs
	 * @return
	 * @see #SHORT_ARRAY_LENGTH
	 */
	private static byte[] shorten(byte[] bs) {
		if (bs == null) {
			return null;
		}
		int bsLength = bs.length;
		byte[] result = new byte[SHORT_ARRAY_LENGTH];
		// copy the first 4 values.
		for (int i = 0; i < SHORT_ARRAY_LENGTH && i < bsLength; i++) {
			result[i] = bs[i];
		}
		// for the left values, do some operations with previous 4 values.
		// here use XOR operator.
		// don't use AND or OR operator here, because they may cause many
		// duplicated values, their dispersions are not as good as XOR.
		for (int i = SHORT_ARRAY_LENGTH; i < bsLength; i++) {
			int j = i % SHORT_ARRAY_LENGTH;
			result[j] = (byte) (result[j] ^ bs[i]);
		}
		return result;
	}

	/**
	 * generate id digest.
	 * 
	 * @param str
	 * @return
	 */
	private static String generateIdDigest(String str) {
		return toHex(shorten(encrypt(str)));
	}

	private static String trimNoNull(String str) {
		if (str == null) {
			return "";
		} else {
			return str.trim();
		}
	}

	/**
	 * protect id, the id type can not be null. return protected id. if there's
	 * any serious problem, may throw run time exception.
	 * 
	 * @param idType
	 * @param id
	 * @return
	 */
	public static String protectId(IdType idType, long id) {
		if (idType == null) {
			throw new RuntimeException("idType can not be null.");
		}
		String str = idType.getShortName() + id;
		return idType.getShortName() + generateIdDigest(str) + id;
	}

	/**
	 * get real id from protected id. if any exception or error occurs, return
	 * 0.
	 * 
	 * @param idType
	 * @param protectedId
	 * @return
	 */
	public static long getId(IdType idType, String protectedId) {
		try {
			if (idType == null) {
				throw new RuntimeException("idType can not be null.");
			}
			long id = 0;
			protectedId = trimNoNull(protectedId);
			if (protectedId.length() < PROTECTED_ID_MIN_LENGTH) {
				// invalid protectedId, return default value 0.
				return 0;
			} else {
				String idTypeStr = protectedId.substring(0, ID_TYPE_LENGTH);
				if (!idType.getShortName().equals(idTypeStr)) {
					// invalid protectedId, return default value 0.
					return 0;
				}
				String tmpIdstr = protectedId.substring(ID_TYPE_LENGTH
						+ HEX_STRING_LENGTH);
				id = Long.parseLong(tmpIdstr);
				String tmpProtectedId = protectId(idType, id);
				if (protectedId.equals(tmpProtectedId)) {
					return id;
				}
			}
		} catch (RuntimeException e) {
			logger.error("IdProtector.getId() error.", e);
		} catch (Exception e) {
			logger.error("IdProtector.getId() error.", e);
		}
		return 0;
	}

	public enum IdType {

		LOGO_PIC_ID("lg");

		private String shortName;

		private IdType(String shortName) {
			this.shortName = shortName;
		}

		public String getShortName() {
			return shortName;
		}

	}

}
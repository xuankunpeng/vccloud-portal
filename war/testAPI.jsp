<%@ page pageEncoding="UTF-8"%>
<html>
	<head>
		<title>VcCloud Portal API</title>
	</head>
	<body>
		<h3>Sign In</h3>
		<form action="user/signIn.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			username:<input type="text" name="username"><br />
			password:<input type="text" name="password"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Sign Out</h3>
		<form action="user/signOut.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Search Conference Call2s</h3>
		<form action="vidyo/searchConferenceCall2s.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			tenantName:<input type="text" name="tenantName"><br />
			callerName:<input type="text" name="callerName"><br />
			startTime:<input type="text" name="startTime"><br />
			endTime:<input type="text" name="endTime"><br />
			orderByClause:<input type="text" name="orderByClause"><br />
			pageSize:<input type="text" name="pageSize"><br />
			pageNo:<input type="text" name="pageNo"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Store Portal Info</h3>
		<form action="vidyo/storePortalInfo.do" method="post" enctype="multipart/form-data">
			client:<input type="text" name="client" value="callback"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			welcomeWord:<input type="text" name="welcomeWord"><br />
			file:<input type="file" name="file"> （支持“bmp“, “jpg“, “wbmp“, “jpeg“, “png“格式）<br>
			callbackURL:<input type="text" name="callbackURL"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Get Portal Info</h3>
		<form action="vidyo/getPortalInfo.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Search Members</h3>
		<form action="user/searchMembers.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			name:<input type="text" name="name"><br />
			pageSize:<input type="text" name="pageSize"><br />
			pageNo:<input type="text" name="pageNo"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Update Member Password</h3>
		<form action="user/updateMemberPassword.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			memberId:<input type="text" name="memberId"><br />
			newPassword:<input type="text" name="newPassword"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Update Password</h3>
		<form action="user/updatePassword.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			password:<input type="text" name="password"><br />
			newPassword:<input type="text" name="newPassword"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Update Display Name</h3>
		<form action="user/updateDisplayName.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			displayName:<input type="text" name="displayName"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Update Member Display Name</h3>
		<form action="user/updateMemberDisplayName.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			memberId:<input type="text" name="memberId"><br />
			displayName:<input type="text" name="displayName"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Search Rooms</h3>
		<form action="vidyo/searchRooms.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Update Room Name</h3>
		<form action="vidyo/updateRoomName.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			roomId:<input type="text" name="roomId"><br />
			name:<input type="text" name="name"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Update Room Pin</h3>
		<form action="vidyo/updateRoomPin.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			roomId:<input type="text" name="roomId"><br />
			pin:<input type="text" name="pin"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Clear Room</h3>
		<form action="vidyo/clearRoom.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			roomId:<input type="text" name="roomId"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Store Legacy</h3>
		<form action="vidyo/storeLegacy.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			id:<input type="text" name="id"><br />
			url:<input type="text" name="url"><br />
			name:<input type="text" name="name"><br />
			extension:<input type="text" name="extension"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Get Legacies</h3>
		<form action="vidyo/getLegacies.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			url:<input type="text" name="url"><br />
			roomId:<input type="text" name="roomId"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Assign Legacies</h3>
		<form action="vidyo/assignLegacies.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			url:<input type="text" name="url"><br />
			roomId:<input type="text" name="roomId"><br />
			legacyIds:<input type="text" name="legacyIds"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Delete Legacy</h3>
		<form action="vidyo/deleteLegacy.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			id:<input type="text" name="id"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Search Legacies</h3>
		<form action="vidyo/searchLegacies.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			keyword:<input type="text" name="keyword"><br />
			pageSize:<input type="text" name="pageSize"><br />
			pageNo:<input type="text" name="pageNo"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Get Room Profile</h3>
		<form action="vidyo/getRoomProfile.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			roomId:<input type="text" name="roomId"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Store Room Profile</h3>
		<form action="vidyo/storeRoomProfile.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			roomId:<input type="text" name="roomId"><br />
			roomProfileName:<input type="text" name="roomProfileName"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Reset Room URL</h3>
		<form action="vidyo/resetRoomURL.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			roomId:<input type="text" name="roomId"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Search Cdrs</h3>
		<form action="vidyo/searchCdrs.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			startTime:<input type="text" name="startTime"><br />
			endTime:<input type="text" name="endTime"><br />
			pageSize:<input type="text" name="pageSize"><br />
			pageNo:<input type="text" name="pageNo"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Get Email Config</h3>
		<form action="vidyo/getEmailConfig.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			domain:<input type="text" name="domain"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Store Email Config</h3>
		<form action="vidyo/storeEmailConfig.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			host:<input type="text" name="host"><br />
			port:<input type="text" name="port"><br />
			email:<input type="text" name="email"><br />
			password:<input type="text" name="password"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Send Email </h3>
		<form action="vidyo/sendEmail.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			attendees:<input type="text" name="attendees"><br />
			organizer:<input type="text" name="organizer"><br />
			description:<input type="text" name="description"><br />
			startTime:<input type="text" name="startTime"><br />
			endTime:<input type="text" name="endTime"><br />
			subject:<input type="text" name="subject"><br />
			location:<input type="text" name="location"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Get Emails </h3>
		<form action="vidyo/getEmails.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			roomId:<input type="text" name="roomId"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Store Room</h3>
		<form action="vidyo/storeRoom.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			extension:<input type="text" name="extension"><br />
			name:<input type="text" name="name"><br />
			<input type="submit" value="Submit"><br />
		</form>
		<h3>Delete Room</h3>
		<form action="vidyo/deleteRoom.do" method="post">
			client:<input type="text" name="client" value="jsonp"><br />
			domain:<input type="text" name="domain"><br />
			portalUrl:<input type="text" name="portalUrl"><br />
			roomId:<input type="text" name="roomId"><br />
			<input type="submit" value="Submit"><br />
		</form>
	</body>
</html>

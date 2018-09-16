<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banque</title>
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>
	<div id="formBanque">
		<form action="controleur.do" method="post">
			<table>
				<tr>
					<td>Code1:</td>
					<td><input type="text" name="code1" /></td>
				</tr>
				<tr>
					<td>Code2:</td>
					<td><input type="text" name="code2" /></td>
				</tr>
				<tr>
					<td>Montant:</td>
					<td><input type="text" name="montant" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="action"
						value="Verser"> <input type="submit" name="action"
						value="Retirer"> <input type="submit" name="action"
						value="Virement"> <input type="submit" name="action"
						value="Ajouter"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<table class="table1">
			<tr>
				<th>Code</th>
				<th>Solde</th>
				<th>Date de création</th>
				<th>Activé</th>
			</tr>
			<c:forEach items="${comptes}" var="cp">
				<tr>
					<td>${cp.code}</td>
					<td>${cp.solde}</td>
					<td>${cp.dateCreation}</td>
					<td>${cp.active}</td>
					<td><a href="controleur.do?action=del&code=${cp.code}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
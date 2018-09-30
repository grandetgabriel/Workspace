<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Crédit bancaire</title>
</head>
<body>
	<div>
		<form action="calculerMensualite.do" method="post">
			<table>
				<tr>
					<td>Montant:</td>
					<td><input type="text" name="montant" /></td>
					<td>euros</td>
				</tr>

				<tr>
					<td>Taux:</td>
					<td><input type="text" name="taux" /></td>
					<td>%</td>
				</tr>
				<tr>
					<td>Durée:</td>
					<td><input type="text" name="duree" /></td>
					<td>mois</td>
				</tr>
			</table>
			<button type="submit">Calculer</button>
		</form>
	</div>
</body>
</html>
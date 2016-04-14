<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>asdasdsa</title>
<meta name="Author" content="Chandra Vedantham">
<meta name="Description" content="Html Page">
<script>
		var DEFAULT_WIDTH = 100;
		var DEFAULT_HEIGHT = 100;

		function CreateTable(rowCount, colCount, srcHolder)
		{
			var srcHolder= document.getElementById(srcHolder);
			if(IsValidNumber(rowCount) && IsValidNumber(colCount) && (srcHolder != null))
			{
				srcHolder.innerHTML = "";
				var srcTable = document.createElement("table");
				srcTable.border = 1;
				srcTable.borderColor = "Black";
				srcTable.height = DEFAULT_HEIGHT;
				srcTable.width = DEFAULT_WIDTH;
				var tmpRow = null;
				var tmpCell = null;
				srcHolder.appendChild(srcTable);
				for(i=0; i<rowCount; i++)
				{
					tmpRow = AppendRow(srcTable)
					for(j=0; j<colCount; j++)
					{
						tmpCell = AppendCell(tmpRow);
						tmpCell.innerText = j;
						tmpCell = null;
					}
					tmpRow = null;
				}
			}
		}

		function AppendRow(srcTable)
		{
			if(srcTable != null)
			{
				return srcTable.insertRow();
			}
			else
			{
				alert("Error while creating table. Cause: Container Table is null!");
			}
		}

		function AppendCell(srcRow)
		{
			if(srcRow != null)
			{
				return srcRow.insertCell();
			}
			else
			{
				alert("Error while creating table. Cause: Container row is null!");
			}
		}

		function IsValidNumber(ipNum)
		{
			if(isNaN(ipNum))
			{
				alert("Invalid Number!");
				return false;
			}
			else if(ipNum < 1)
			{
				alert("Number should be greater than 0!");
				return false;
			}
			else
			{
			return true;
			}
		}
	</script>
</head>
<body>
<!--
	<table>
	<tr>
		<td>No. Of Rows: </td>
		<td><input type=text id=txtRows value=1 /></td>
	</tr>
	<tr>
		<td>No. Of Columns: </td>
		<td><input type=text id=txtCols value=1 /> </td>
	</tr>
	<tr>
<td colspan=2 align=right><input type=button name=cmdCreate value="Create Table" onClick="CreateTable(5, 5,'divHolder')" /></td>
	</tr>
	</table>
	<div id=divHolder>
		
	</div>
	
	asdsadsa-->
</body>
</html>
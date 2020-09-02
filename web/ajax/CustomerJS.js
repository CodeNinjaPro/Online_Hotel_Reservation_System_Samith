selectedRowToInput();
function selectedRowToInput() {
	var table = document.getElementById('table'), rIndex;
	for (var i = 1; i < table.rows.length; i++) {
		table.rows[i].onclick = function () {
			rIndex = this.rowIndex;
			document.getElementById("customer_").value = this.cells[1].textContent;
			document.getElementById("name").value = this.cells[2].textContent;
			document.getElementById("address").value = this.cells[3].textContent;
			document.getElementById("email").value = this.cells[4].textContent;
			document.getElementById("loyalty").value = this.cells[5].textContent;
			document.getElementById("date_time").value = this.cells[6].textContent;
		};
	}
}

function save() {
	var customer_ = $('#customer_').val();
	var name = $('#name').val();
	var address = $('#address').val();
	var email = $('#email').val();
	var loyalty = $('#loyalty').val();
	var date_time = $('#date_time').val();
	var action = "insert";
	if(customer_ === "" || name === "" || address === "" || email === "" || loyalty === "" || date_time === ""){
		alert("Please Enter All Details")
	} else {
		$.ajax({
			url: 'CustomerServlet',
			method: 'POST',
			data: {action: action, customer_: customer_, name: name, address: address, email: email, loyalty: loyalty, date_time: date_time},
			success: function (resultText) {
				alert(resultText);
				$("#table").find("tr:gt(0)").remove();
				load();
			},
			error: function (jqXHR, exception) {
				alert("Fail Ajax");
			}
		});
	}
}

function update() {
	var customer_ = $('#customer_').val();
	var name = $('#name').val();
	var address = $('#address').val();
	var email = $('#email').val();
	var loyalty = $('#loyalty').val();
	var date_time = $('#date_time').val();
	var action = "update";
	customer_ = parseInt(customer_);
	if(customer_ === 0){
		alert("Please Select to Update")
	} else if(customer_ === "" || name === "" || address === "" || email === "" || loyalty === "" || date_time === ""){
		alert("Please Enter All Details")
	} else {
		$.ajax({
			url: 'CustomerServlet',
			method: 'POST',
			data: {action: action, customer_: customer_, name: name, address: address, email: email, loyalty: loyalty, date_time: date_time},
			success: function (resultText) {
				alert(resultText);
				$("#table").find("tr:gt(0)").remove();
				load();
			},
			error: function (jqXHR, exception) {
				alert("Fail Ajax");
			}
		});
	}
}

function delet() {
	var customer_ = $('#customer_').val();
var action = "delete";
	customer_ = parseInt(customer_);
	if(customer_ === 0){
		alert("Please Select to Update")
	} else {
		var r = confirm("Are you Sure?");
		if (r == true) {
			$.ajax({
			url: 'CustomerServlet',
			method: 'POST',
			data: {action: action, customer_: customer_},
			success: function (resultText) {
				$("#table").find("tr:gt(0)").remove();
				load();
				alert("Deleted")
			},
			error: function (jqXHR, exception) {
				alert("Fail Ajax");
			}
		});
		} else {
			alert("Not Deleted")
		}
	}
}

function load() {
	var table = document.getElementById('table');
	var action = "serch";
		$.ajax({
			url: 'CustomerServlet',
			method: 'POST',
			data: {action: action},
			success: function (resultText) {
				resultText = resultText.replace("[", "");
				resultText = resultText.replace("]", "");
				var c = [];
				c = resultText;
				if (c.length > 5) {
					var step1 = [];
					var step2 = [];
					step1 = resultText.split("~");
					for (i = 0; i < step1.length; ++i) {
						step2 = step1[i].split("_");
						var newRow = table.insertRow(table.length),
							cell0 = newRow.insertCell(0),
							cell1 = newRow.insertCell(1),
							cell2 = newRow.insertCell(2),
							cell3 = newRow.insertCell(3),
							cell4 = newRow.insertCell(4),
							cell5 = newRow.insertCell(5),
							cell6 = newRow.insertCell(6),
							cell7 = newRow.insertCell(7),
							k = i + 1;
							cell0.innerHTML = k;
							cell1.innerHTML = step2[0];
							cell2.innerHTML = step2[1];
							cell3.innerHTML = step2[2];
							cell4.innerHTML = step2[3];
							cell5.innerHTML = step2[4];
							cell6.innerHTML = step2[5];
							cell7.innerHTML = step2[6];
						}
					}
				},
			error: function (jqXHR, exception) {
				alert("Fail Ajax")
			}
		});
		document.getElementById("form").reset();
}

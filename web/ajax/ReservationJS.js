selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 0; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("reservation_id").value = this.cells[1].textContent;
            document.getElementById("room_id").value = this.cells[2].textContent;
            document.getElementById("customer_id").value = this.cells[3].textContent;
            document.getElementById("in_date").value = this.cells[4].textContent;
            document.getElementById("out_date").value = this.cells[5].textContent;
            document.getElementById("date_time").value = this.cells[6].textContent;
        };
    }
}

function save() {
    var reservation_id = $('#reservation_id').val();
    var room_id = $('#room_id').val();
    var customer_id = $('#customer_id').val();
    var in_date = $('#in_date').val();
    var out_date = $('#out_date').val();
    var date_time = $('#date_time').val();
    var action = "insert";
    if (reservation_id === "" || room_id === "" || customer_id === "" || in_date === "" || out_date === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'ReservationServlet',
            method: 'POST',
            data: {action: action, reservation_id: reservation_id, room_id: room_id, customer_id: customer_id, in_date: in_date, out_date: out_date, date_time: date_time},
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
    var reservation_id = $('#reservation_id').val();
    var room_id = $('#room_id').val();
    var customer_id = $('#customer_id').val();
    var in_date = $('#in_date').val();
    var out_date = $('#out_date').val();
    var date_time = $('#date_time').val();
    var action = "update";
    reservation_id = parseInt(reservation_id);
    if (reservation_id === 0) {
        alert("Please Select to Update")
    } else if (reservation_id === "" || room_id === "" || customer_id === "" || in_date === "" || out_date === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'ReservationServlet',
            method: 'POST',
            data: {action: action, reservation_id: reservation_id, room_id: room_id, customer_id: customer_id, in_date: in_date, out_date: out_date, date_time: date_time},
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
    var reservation_id = $('#reservation_id').val();
    var action = "delete";
    reservation_id = parseInt(reservation_id);
    if (reservation_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'ReservationServlet',
                method: 'POST',
                data: {action: action, reservation_id: reservation_id},
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
    var dropdown1 = document.getElementById('room_id');
    $('#room_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'RoomServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {


            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");

            var c = [];
            c = resultText;


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[2];
                    option.value = step2[0];
                    dropdown1.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var dropdown2 = document.getElementById('customer_id');
    $('#customer_id')
            .find('option')
            .remove()
            .end()
            ;

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


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[1];
                    option.value = step2[0];
                    dropdown2.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var action = "serch";
    $.ajax({
        url: 'ReservationServlet',
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
            selectedRowToInput();

        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax")
        }
    });
    document.getElementById("form").reset();

}

function Export() {
    html2canvas(document.getElementById('report'), {
        onrendered: function (canvas) {
            var data = canvas.toDataURL();
            var docDefinition = {
                content: [{

                        image: data,
                        width: 500
                    }]
            };
            pdfMake.createPdf(docDefinition).download("Report.pdf");
        }
    });
}

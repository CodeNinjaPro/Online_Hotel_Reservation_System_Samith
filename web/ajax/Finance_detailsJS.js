selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("finance_details_id").value = this.cells[1].textContent;
            document.getElementById("description").value = this.cells[2].textContent;
            document.getElementById("type").value = this.cells[3].textContent;
            document.getElementById("status").value = this.cells[4].textContent;
            document.getElementById("date_time").value = this.cells[5].textContent;
        };
    }
}

function save() {
    var finance_details_id = $('#finance_details_id').val();
    var description = $('#description').val();
    var type = $('#type').val();
    var status = $('#status').val();
    var date_time = $('#date_time').val();
    var action = "insert";
    if (finance_details_id === "" || description === "" || type === "" || status === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'Finance_detailsServlet',
            method: 'POST',
            data: {action: action, finance_details_id: finance_details_id, description: description, type: type, status: status, date_time: date_time},
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
    var finance_details_id = $('#finance_details_id').val();
    var description = $('#description').val();
    var type = $('#type').val();
    var status = $('#status').val();
    var date_time = $('#date_time').val();
    var action = "update";
    finance_details_id = parseInt(finance_details_id);
    if (finance_details_id === 0) {
        alert("Please Select to Update")
    } else if (finance_details_id === "" || description === "" || type === "" || status === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'Finance_detailsServlet',
            method: 'POST',
            data: {action: action, finance_details_id: finance_details_id, description: description, type: type, status: status, date_time: date_time},
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
    var finance_details_id = $('#finance_details_id').val();
    var action = "delete";
    finance_details_id = parseInt(finance_details_id);
    if (finance_details_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'Finance_detailsServlet',
                method: 'POST',
                data: {action: action, finance_details_id: finance_details_id},
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
        url: 'Finance_detailsServlet',
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
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
                    cell6.innerHTML = step2[5];
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

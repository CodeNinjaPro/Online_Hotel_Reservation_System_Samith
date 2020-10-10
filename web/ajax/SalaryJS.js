function salary() {
    var employee_id = $('#employee_id').val();
    var year = $('#year').val();
    var month = $('#month').val();

    $.ajax({
        url: 'SalaryViewServlet',
        method: 'POST',
        data: {employee_id: employee_id, year: year, month: month},
        success: function (resultText) {
            
            var data = resultText.split("_");
            
            document.getElementById("employee_id_s").value = data[0];
            document.getElementById("year_s").value = data[1];
            document.getElementById("month_s").value = data[2];
            document.getElementById("no_of_days").value = data[3];
            document.getElementById("salary_per_day").value = data[4];
            document.getElementById("total_for_epf").value = data[5];
            document.getElementById("no_of_ot").value = data[6];
            document.getElementById("ot_rate").value = data[7];
            document.getElementById("allowance").value = data[8];
            document.getElementById("gross_salary").value = data[9];
            document.getElementById("epf_deduction").value = data[10];
            document.getElementById("net_salary").value = data[11];
        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax");
        }
    });
}

function load() {

    var dropdown1 = document.getElementById('employee_id');
    $('#employee_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'EmployeeServlet',
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
                    dropdown1.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });

}

function Export() {
    html2canvas(document.getElementById('salary_sheet'), {
        onrendered: function (canvas) {
            var data = canvas.toDataURL();
            var docDefinition = {
                content: [{

                        image: data,
                        width: 500
                    }]
            };
            pdfMake.createPdf(docDefinition).download("SalarySheet.pdf");
        }
    });
}


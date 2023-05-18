<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food List For A Week</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
    <form action="MenuController" method="post">
        <input type="text" name="page" value="${page}" hidden>
        <input type="text" name="action" value="show" hidden>
        <button type="submit" style="height:40px;width:100px;margin-bottom: 10px;background:green;border-radius:10px;color:white;margin-left:100px;margin-top:50px">Back to Menu</button>
    </form>
    <h1 style="text-align: center;">Food List For Week ${page}</h1>
    <br />
    <table class="table" id="simple_table" style="width:800px;margin-left:300px">
        <tr><strong>
            <th>Index</th>
            <th>Food Name</th>
            <th>Amount (g)</th>
        </strong></tr>
        <c:set var="i" value="1" scope="page"></c:set>
        <c:forEach items="${list.keySet()}" var="x">
            <tr>
                <td>${i}</td>
                <td><img src="${x.getIcon()}" style="width:20px;height:20px">${x.getFoodname()}</td>
                <td>${list.get(x)}</td>
            </tr>
            <c:set var="i" value="${i + 1}"></c:set>
        </c:forEach>
        
    </table>
    <br/>
    <input type="button" onclick="generate()" value="Export To PDF" style="margin-left:650px;margin-bottom: 50px"/>
    <script src="script.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>
            <jsp:include page="../index/UserFooter.jsp" />

</body>
<script>
    function generate() {
    var doc = new jsPDF('p', 'pt', 'letter');
    var htmlstring = '';
    var tempVarToCheckPageHeight = 0;
    var pageHeight = 0;
    pageHeight = doc.internal.pageSize.height;
    specialElementHandlers = {
        // element with id of "bypass" - jQuery style selector  
        '#bypassme': function (element, renderer) {
            // true = "handled elsewhere, bypass text extraction"  
            return true
        }
    };
    margins = {
        top: 150,
        bottom: 60,
        left: 40,
        right: 40,
        width: 600
    };
    var y = 20;
    doc.setLineWidth(2);
    doc.text(200, y = y + 30, "FOOD LIST FOR WEEK ${page}");
    doc.autoTable({
        html: '#simple_table',
        startY: 70,
        theme: 'grid',
        columnStyles: {
            0: {
                cellWidth: 40,
            },
            1: {
                cellWidth: 150,
            },
            2: {
                cellWidth: 120,
            }
        },
        styles: {
            minCellHeight: 20
        }
    })
    doc.save('FoodListWeek${page}.pdf');
}
</script>
</html>
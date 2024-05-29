<%--
  Created by IntelliJ IDEA.
  User: Dũng Phạm
  Date: 29/05/2024
  Time: 11:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Custom Format Price --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
<script>
    // Set lại cách định dạng dấu phân cách hàng nghìn và thập phân
    numeral.register('locale', 'custom', {
        delimiters: {
            thousands: '.',
            decimal: ','
        }
    });
    numeral.locale('custom');
</script>

<script type="text/javascript" src="/TicketSystem/resources/materialize/js/jQuery.js"></script>
<script type="text/javascript" src="/TicketSystem/resources/scripts/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="/TicketSystem/resources/materialize/js/materialize.min.js"></script>
<script type="text/javascript">
    $(document).ready(function init() {
        $(".button-collapse").sideNav();
        $('.modal-trigger').leanModal();
        $('select').material_select();
        $("#mainTable").tablesorter({sortList: [[1,0], [3,0]]} ); 
    });
</script>
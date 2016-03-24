$(document).ready(function() {
    $('#toggleFormateur').click(function(){
    	$('#Formateur').toggle('slow');
    });
    
    $('#toggleStagiaire').on("click",function(){
    	$('#Stagiaire').toggle('slow');
    });
    
    $('#toggleAdmin').click(function(){
    	$('#Admin').toggle('slow');
    });
    
    $('#toggleFormation').click(function(){
    	$('#Formation').toggle('slow');
    });
    
    $('#toggleSession').click(function(){
    	$('#Session').toggle('slow');
    });
    
    $(function() {
        $("[id*='dateDebut']").datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 1,
            onClose: function( selectedDate ) {
              $( "[id*='dateDebut']" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
            }
          });
        $("[id*='dateFin']").datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 1,
            onClose: function( selectedDate ) {
              $( "[id*='dateFin']" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
            }
          });
    });
    
  
});


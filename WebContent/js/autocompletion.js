$(document)
    .ready(
        function() {
	        var termTemplate = "<span class='ui-autocomplete-term'>%s</span>";
	        $("#villes")
	            .autocomplete(
	                {
	                  source : function(request, response) {
	                	  $.ajax({
			                    url : "complete",
			                    type : "GET",
			                    dataType : "text",
			                    data : {
			                    	tocomplete : request.term
			                    },
			                    success : function(data) {
			                    	console.log(data);
				                    data = data.split("!");

				                    response($.map(data, function(items) {
					                    var list = items.split(",");
					                    var item = {
					                      name : list[0],
					                      value : list[0]
					                    }
					                    if (item.name == "")
						                    return;
					                    console.log(item)
					                    return {
					                      label : item.name.trim(),
					                      value : item.value,
					                    }
				                    }));
			                    },  
	                	 
		                    error : function(error) {

			                    console.log(error);
		                    }
		                  });
	                  },
	                  open : function(e, ui) {
	                    var acData = $(this).data('ui-autocomplete');
	                    acData
	                    .menu
	                    .element
	                    .find('li')
	                    .each(function () {
	                        var me = $(this);
	                        var keywords = acData.term.split(' ').join('[');
	                        me.html(me.text().replace(new RegExp("(" + keywords + ")", "gi"), '<b>$1</b>'));
	                     });
	                  },
	                  minLength : 3
	                });
        });
function getMairie() {
	$.ajax({
	  url : "/projetJEE/complete",
	  type : "GET",
	  dataType : "text",
	  data : {
		  INSEE : $("#villes").val()
	  },
	  success : function(data) {
		  $("#mairie").empty();
		  $("#mairie").append(data);
	  },
	  error : function(error) {
		  alert('error: ' + error);
	  }
	});
}
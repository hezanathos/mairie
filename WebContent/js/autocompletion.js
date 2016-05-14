$(document)
    .ready(
        function() {

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
			              
				                    data = data.split("!");

				                    response($.map(data, function(items) {
					                    var list = items.split(",");
					                    var item = {
					                      name : list[0],
					                      value : list[0]
					                    }
					                    if (item.name == "")
						                    return;
					        
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

	                  minLength : 2
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
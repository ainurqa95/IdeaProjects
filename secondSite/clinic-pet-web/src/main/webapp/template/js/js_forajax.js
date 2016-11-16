


$(document).ready(function(){

                   $(".one_tooltip").click(function () {
                    
                      var id = $(this).attr("data-id");
                      $.post("/cart/addAjax/"+id, {}, function (data) {
                         $("#count_of_items").html(data);
                          });
                       return false;
                      });
                   });
$(document).ready(function(){

                   $(".one_tooltip").click(function () {
                    
                      var id = $(this).attr("data-id");
                      $.post("/cart/addAjax/"+id, {}, function (data) {
                         $("#count_of_items").html(data);
                          });
                       return false;
                      });
                   });
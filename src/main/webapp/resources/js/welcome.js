$(document).ready(function(){
	
	loadNotes();
	
	$('#user-email').keyup(function () {
		console.log($("#user-email").val());
    	if(isValidEmail($("#user-email").val())){
    		$('#email_error').hide(300);
		}
    	else{
    		$('#email_error').show(300);
    	}
    });
	
	$(".modifyBtn").click(function(){
		
		var clickedNoteId = $(this).parent().children('.noteId').val();
		var clickedNoteBody = $(this).parent().siblings('.note-post').children('.note-body').text();
		var newNoteBody = "";
		
		swal({   
		    closeOnConfirm: false, 
			title: "글 수정하기",   
			text: '<textarea class="modify-textarea" name="bodyText">'+clickedNoteBody+'</textarea>',
			html: true 
			}, function(){
				
				newNoteBody += $(".modify-textarea").val();
				
				swal({  
					title: "글 수정하기",   
					text: "비밀번호를 입력하세요.",   
					type: "input",   
					inputType :"password",
					showCancelButton: true,  
					allowOutsideClick : true,
					showLoaderOnConfirm: true, 
					closeOnConfirm: false,   
					animation: "slide-from-top",   
					inputPlaceholder: "*******" 
					}, function(inputValue){   
						if (inputValue === false) 
							return false;      
						if (inputValue === "") {     
							swal.showInputError("You need to write something!");     
							return false;
						}
						
						var data = {
								"pwd" : inputValue, 
								"noteId" : clickedNoteId,
								"newNoteBody" : newNoteBody
								};
						
						  $.ajax({
					            url:'/note',
					            type : 'PUT',
					            data : data,
					            dataType:'json',
					            complete:function(data){
					            	var state = $(data).attr('responseText');
					            	if(state == "success"){
					            		swal({
					            			title : "글 수정 성공!",
					            			text : "성공적으로 변경되었습니다.",
					            			type : "success",
					            			showCancelButton : false,
					            			closeOnConfrim : false
					            			
					            		}, function(){
					            			location.reload();
					            		});
					            	}
					            	else{
					            		swal({
					            			title : "글 수정 실패!",
					            			text : "비밀번호가 잘못되었습니다.",
					            			type : "error",
					            			showCancelButton : false,
					            			closeOnConfrim : false
					            			
					            		}, function(){
					            			location.reload();
					            		});
					            	}
					            }
					        })
						
						 
					});
			});
		
	});
	
});

function loadNotes(){
	var notesJson = $("#notesList").val();
	var notesList = JSON.parse(notesJson);
	var listLength = notesList.length;
	for (var i = 0 ; i < listLength; i++){
		
		var registDateTime = moment( notesList[i].registeredDate );
		var modifiedDateTime = moment( notesList[i].modifiedDate );
		var registFormatted = registDateTime.format('LLL');
		var modifiedFormatted = modifiedDateTime.format('LLL');
		
		if(modifiedFormatted == "Invalid date"){
			modifiedFormatted = "";
			$('.update-date').remove();
		}
		
		var html = '';
		html += '<article class="row">';
		html += 	'<div class="col-md-12 col-xs-12 col-sm-12">';
		html += 		'<div class="panel panel-default">';
		html += 			'<div class="panel-body">';
		html += 				'<header class="text-left">';
		html += 					'<div class="note-user"><i class="fa fa-user"></i>'+notesList[i].userEmail+'</div>';
		html += 					'<time><i class="fa fa-clock-o"></i>'+registFormatted+'</time>';
		html += 					'<time id ="update-date"><i class="fa fa-wrench"></i>'+modifiedFormatted+'</time>';
		html += 				'</header>';
		html +=					'<div class="note-post">';
		html +=						'<p class="note-body">   '+notesList[i].bodyText+'</p>';
		html +=					'</div>';
		html +=					'<p class="text-right">';
		html += 					'<a class="modifyBtn" href="#" class="btn btn-default btn-sm"><i class="fa fa-ellipsis-h"></i></a>';
		html +=						'<input type="hidden" class="noteId" value='+notesList[i].id+'>';
		html +=					'</p>';
		html +=				'</div>';
		html +=			'</div>';
		html +=		'</div>';
		html += '</article>';
		
		
		$("#notes-list").after(html);
		if(modifiedFormatted == ""){
			$('#update-date').remove();
		}
	}
	$("#notesList").remove();
}


function isValidEmail(email) {
	var email_pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
    return email_pattern.test(email);
};
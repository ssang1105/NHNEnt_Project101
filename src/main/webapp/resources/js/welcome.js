$(document).ready(function(){
	loadNotes();
	
});

function loadNotes(){
	var notesJson = $("#notesList").val();
	var notesList = JSON.parse(notesJson);
	var listLength = notesList.length;
	for (var i = 0 ; i < listLength; i++){
		
		
		var dateTime = moment( notesList[i].registeredDate );
		var formatted = dateTime.format('LLL');
		
		var html = '';
		html += '<article class="row">';
		html += 	'<div class="col-md-12 col-xs-12 col-sm-12">';
		html += 		'<div class="panel panel-default">';
		html += 			'<div class="panel-body">';
		html += 				'<header class="text-left">';
		html += 					'<div class="comment-user"><i class="fa fa-user"></i>'+notesList[i].userEmail+'</div>';
		html += 					'<time><i class="fa fa-clock-o"></i>'+formatted+'</time>'; 
		html += 				'</header>';
		html +=					'<div class="comment-post">';
		html +=						'<p>   '+notesList[i].bodyText+'</p>';
		html +=					'</div>';
		html +=					'<p class="text-right"><a href="#" class="btn btn-default btn-sm"><i class="fa fa-ellipsis-h"></i></a></p>';
		html +=				'</div>';
		html +=			'</div>';
		html +=		'</div>';
		html += '</article>';
		
		$("#notes-list").after(html);
	}
}
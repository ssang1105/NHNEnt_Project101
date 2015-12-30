<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko-kr">
<head>
	<title>Guest Book</title>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet" >
	<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="/css/sweetalert.css" rel="stylesheet" type="text/css">
	<link href="/css/welcome.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col-md-12 col-xs-12 col-sm-12">
	    	<section class="note-window">
	    		<article class="row">
		          <div class="col-md-12 col-xs-12 col-sm-12">
						<div class="widget-area">
							<div class="status-upload">
								<form method="POST" action="/note" autocomplete="off">
									<textarea name="bodyText" placeholder="Let's leave a comment here!" ></textarea>
									<div class="submit_container">
										<ul class=".col-xs-12 .col-sm-6 .col-lg-8">
											<li><div class="input-prepend"><span class="add-on"><i class="fa fa-envelope-o"></i></span><input type="email" id="" name="userEmail"></div></li>
											<li><div class="input-prepend"><span class="add-on"><i class="fa fa-unlock-alt"></i></span><input type="password" id="" name="password"></div></li>
										</ul>
										<button type="submit" class=".col-xs-6 .col-lg-4 btn btn-success green"><i class="fa fa-share"></i> Submit</button>
									</div>
									
								</form>
							</div>
						</div>
					</div>
				</article>
			</section>
					
	        <section id ="notes-list" class="notes-list">
	        <!-- js로 동적으로 note 추가 -->
	        </section>
	    </div>
	  </div>
	</div>
	
	
	<input type="hidden" id="notesList" value='${notesList}'/>


	
</body>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/moment.js"></script>
<script src="/js/sweetalert.min.js"></script>
<script src="/js/welcome.js"></script>

</html>
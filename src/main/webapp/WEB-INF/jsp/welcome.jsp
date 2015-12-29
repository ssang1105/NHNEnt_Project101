<!DOCTYPE html>
<html lang="ko-kr">
<head>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet" >
	<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="/css/welcome.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col-md-12 col-xs-12 col-sm-12">
	    	<section class="comment-window">
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
					
	        <section class="comment-list">
	          <!-- First Comment -->
	          <article class="row">
	            <div class="col-md-12 col-xs-12 col-sm-12">
	              <div class="panel panel-default">
	                <div class="panel-body">
	                  <header class="text-left">
	                    <div class="comment-user"><i class="fa fa-user"></i> Sang Woo</div>
                    	<time><i class="fa fa-clock-o"></i> Dec 16, 2014</time>
	                  </header>
	                  <div class="comment-post">
	                    <p>
	                     11 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
	                    </p>
	                  </div>
	                  <p class="text-right"><a href="#" class="btn btn-default btn-sm"><i class="fa fa-ellipsis-h"></i></a></p>
	                </div>
	              </div>
	            </div>
	          </article>
	          
	            <article class="row">
	            <div class="col-md-12 col-xs-12 col-sm-12">
	              <div class="panel panel-default">
	                <div class="panel-body">
	                  <header class="text-left">
	                    <div class="comment-user"><i class="fa fa-user"></i> Sang Woo</div>
                    	<time><i class="fa fa-clock-o"></i> Dec 16, 2014</time>
	                  </header>
	                  <div class="comment-post">
	                    <p>
	                     11 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
	                    </p>
	                  </div>
	                  <p class="text-right"><a href="#" class="btn btn-default btn-sm"><i class="fa fa-ellipsis-h"></i></a></p>
	                </div>
	              </div>
	            </div>
	          </article>
	        </section>
	    </div>
	  </div>
	</div>
	
	<input type="hidden" id="noteNumber" value='${noteNumber}'/>
	<input type="hidden" id="notes" value='${notes}'/>


	
</body>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/welcome.js"></script>

</html>
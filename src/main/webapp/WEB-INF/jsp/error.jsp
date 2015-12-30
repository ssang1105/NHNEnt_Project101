<html>
<body>
	<link href="/css/sweetalert.css" rel="stylesheet" type="text/css">
	<script src="/js/sweetalert.min.js"></script>
<script type="text/javascript">
    var message = '${message}';

    swal({   title: "Error!",
		text: message,
		type: "error",   confirmButtonColor: "#DD6B55",   confirmButtonText: "OK",
		}, function(isConfirm){
			if (isConfirm) {
                document.location.href = window.history.back();
			}
		});

</script>
</body>
</html>

$(document).ready(function() {

	$(".close").click(function() {
		$("#message_show").hide();
	})

	$("#submit").click(function() {
		var username = $("#username").val();
		var beforePassword = $("#beforePassword").val();
		var password = md5(beforePassword);
		$("#password").val(password);
		$("#form-signin").submit();
	})
});

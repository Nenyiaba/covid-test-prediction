$(document).ready(function(){
	//alert("hefdw");
	let answers = {};
	let APPLICATION_PORT = "8088";

	$("#submit-button").click(() => {
		answers["pneumonia"] = $("input[name='q-1']:checked"). val();
		answers["diabetes"] = $("input[name='q-2']:checked"). val();
		answers["breathingDifficulty"] = $("input[name='q-3']:checked"). val();
		answers["asthma"] = $("input[name='q-4']:checked"). val();
		answers["hypertensive"] = $("input[name='q-5']:checked"). val();
		answers["otherCommunicableDisease"] = $("input[name='q-6']:checked"). val();
		answers["stroke"] = $("input[name='q-7']:checked"). val();
		answers["obese"] = $("input[name='q-8']:checked"). val();
		answers["kidneyFailure"] = $("input[name='q-9']:checked"). val();
		answers["smoker"] = $("input[name='q-10']:checked"). val();
		console.log(answers);
		makeApiCall(answers);
	});

	function makeApiCall(requestObject){
		requestObject = JSON.stringify(requestObject);
		$.ajax({
			url: `Http://localhost:${APPLICATION_PORT}/api/predict`,
			type: "POST",
			contentType: "application/json; charset-utf-8",
			data: requestObject,
			dataType: "json",
			success: function(res){
				let prediction = res.prediction === "1" ? "TEST REQUIRED" : "NO TEST REQUIRED";
				document.getElementById("prediction-result").innerHTML = prediction;
				console.log(res);
			},
			error: function(jqXHR, status, err){
				if(jqXHR.responseJSON == null){
					alert("ERROR CONNECTING TO SERVER")
				}
				else{
					let errorResponse = jqXHR.responseJSON;
					alert(errorResponse.error + " : "+ errorResponse.errors[0].defaultMessage);
				}

			}
		});
	}
});

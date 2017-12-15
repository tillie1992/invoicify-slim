$(function() {

	// the function behavior after submit
	$('#create-rate-fee-form').submit(function(e) {
		e.preventDefault();

		// going to create an object when you see curly braces
		let ratefee = {
			quantity: $('#quantity').val(),
			rate: $('#rate').val(),
			clientId: $('#rate-fee-company').val(),	
			description: $('#rate-fee-description').val()	
		};
		
		let headers = {
			'X-CSRF-token': $('#rate-fee-csrf').val()
			
			
		};
		let settings = {
			url: '/api/ratefees',
			data: JSON.stringify(ratefee),
			contentType: 'application/json',
			headers: headers
		};
		$.post(settings)
		 .done(function (data){
			 $('#billing-table')
			 	.append(`<tr>
			 				<td>${data.description}</td>
			 				<td>${data.createdBy.username}</td>
			 				<td>${data.client.name}</td>
			 				<td>${data.amount}</td>
			 				<td>${data.quantity}</td>
			 				<td>${data.total}</td>
			 			</tr>`
		 });
	});

});

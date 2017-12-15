$(function() {

	// the function behavior after submit
	$('#create-flat-fee-form').submit(function(e) {
		e.preventDefault();

		// going to create an object when you see curly braces
		let flatfees = {
			amount: $('#amount').val(),
			clientId: $('#flat-fee-company').val(),	
			description: $('#flat-fee-description').val()	
		};
		
		let headers = {
			'X-CSRF-token': $('#flat-fee-csrf').val()
			
		};
		let settings = {
			url: '/api/flatfees',
			data: JSON.stringify(flatfees),
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

$(function() {

	// the function behavior after submit
	$('#create-companies-form').submit(function(e) {
		e.preventDefault();

		// going to create an object when you see curly braces
		let company = {
			name : $('#company-name').val()
		};
		let headers ={
			'X-CSRF-TOKEN': $('#company-csrf').val()
			
		};
		let settings ={
			url: '/api/admin/companies',
			data: JSON.stringify(company),
			contentType: 'application/json',
			headers:headers
		};
		$.post(settings)
		 .done(function (data){
			 $('#company-list')
			 	.append(`<li>${data.name}</li>`);
			 $('#company-name').val('');
		 });
	});

});

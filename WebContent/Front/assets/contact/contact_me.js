$(function() {
    $("input,textarea").jqBootstrapValidation({
        preventSubmit: true,
        submitError: function($form, event, errors) {
            // additional error messages or events
        },
        submitSuccess: function($form, event) {
            event.preventDefault(); // prevent default submit behaviour
            // get values from FORM
            var fname = $("input#form-first-name").val();
            var lname = $("input#form-last-name").val();
            var subject = $("input#form-subject").val();
            var email = $("input#form-email").val();
            var message = $("textarea#form-comment").val();
            var firstName = fname; // For Success/Failure Message
            // Check for white space in name for Success/Fail message
            if (firstName.indexOf(' ') >= 0) {
                firstName = name.split(' ').slice(0, -1).join(' ');
            }
            $.ajax({
                url: "././mail/contact_me.php",
                type: "POST",
                dataType: 'json',
                data: {
                    fname: fname,
                    lname: lname,
                    subject: subject,
                    email: email,
                    message: message
                },
                cache: false,
                success: function(data) {
                	if(data.error){
	                    // Fail message
	                    $('#success').html("<div class='alert alert-danger'>");
	                    $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;").append("</button>");
	                    $('#success > .alert-danger').append("<strong>Sorry " + firstName + ", it seems that my mail server is not responding. Please try again later!");
	                    $('#success > .alert-danger').append('</div>');
	                    //clear all fields
	                    $('#contactForm').trigger("reset");
                	}
                	else if(data.success){
	                    // Success message
	                    $('#success').html("<div class='alert alert-success'>");
	                    $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;").append("</button>");
	                    $('#success > .alert-success').append("<strong>Your message has been sent. </strong>");
	                    $('#success > .alert-success').append('</div>');
	                    //clear all fields
	                    $('#contactForm').trigger("reset");
					}
                }
            })
        },
        filter: function() {
            return $(this).is(":visible");
        },
    });
});


/*When clicking on Full hide fail/success boxes */
$('#form-first-name').focus(function() {
    $('#success').html('');
});

<?php
// Check for empty fields
if(empty($_POST['fname']) || empty($_POST['email']) || empty($_POST['lname']) || !filter_var($_POST['email'],FILTER_VALIDATE_EMAIL)){
	echo json_encode(array('error'=>'true'));
	return false;
}

$fname = $_POST['fname'];
$lname = $_POST['lname'];
$email_address = $_POST['email'];
$message = $_POST['message'];
$userSubject = $_POST['subject'];

$subject = "Website Contact Form:  $name";



// Create the email and send the message
$to = 'yourname@yourdomain.com'; // Add your email address inbetween the '' replacing yourname@yourdomain.com - This is where the form will send a message to.
$email_body = "You have received a new message from your website contact form.\n\n"."Here are the details:\n\nFirst Name: $fname\n\nLast Name: $lname\n\nEmail Address: $email_address\n\nSubject: $userSubject\n\nMessage: $message";
$headers = "From: noreply@yourdomain.com\n"; // This is the email address the generated message will be from. We recommend using something like noreply@yourdomain.com.
$headers .= "Reply-To: $email_address";	
mail($to,$subject,$email_body,$headers);
echo json_encode(array('success'=>'true'));
return true;
?>
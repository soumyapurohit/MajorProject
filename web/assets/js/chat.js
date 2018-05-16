$(document).ready(function(){

	$('.chat_head').click(function(){
		$('.chat_body').slideToggle('slow');
	});
	$('.msg_head').click(function(){
		$('.msg_wrap').slideToggle('slow');
	});
	
	$('.close').click(function(){
		$('.msg_box').hide();
	});
	
	$('.user').click(function(){

		$('.msg_wrap').show();
		$('.msg_box').show();
	});
	
	$('#submit1').click(
    function(e){
        
            
            var msg = $('#textarea1').val();
			$('#textarea1').val('');
			if(msg!='')
			$('<div class="msg_b">'+msg+'</div>').insertBefore('.msg_push');
			$('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
        
    });
	
	$('#submit2').click(
    function(e){
        
            
            var msg = $('#textarea2').val();
			$('#textarea2').val('');
			if(msg!='')
			$('<div class="msg_a">'+msg+'</div>').insertBefore('.msg_push');
			$('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
        
    });
	
	 function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result).insertBefore('.msg_push');;
            }
            
            reader.readAsDataURL(input.files[0]);
			$('.msg_body').scrollTop($('.msg_body')[15].scrollHeight);
        }
    }
    
    $("#image").change(function(){
        readURL(this);
    });
	
	
	
	
	
});
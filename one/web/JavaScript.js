
function validate()
{	
	let x=0;

	if ( document.getElementById("i1").value == "" )
	    {
	    	document.getElementById("i1").style.borderColor='red';
		x=x+1;		
	    }
	else
	    document.getElementById("i1").style.borderColor='';	
	    
	if ( document.getElementById("i2").value == "" )
	    {
	    	document.getElementById("i2").style.borderColor='red';	
		x=x+1;		
	    }
	else
	    document.getElementById("i2").style.borderColor='';	
	    
	if ( document.getElementById("i3").value == "" )
	    {
	    	document.getElementById("i3").style.borderColor='red';	
			x=x+1;		
	    }
	else
	    document.getElementById("i3").style.borderColor='';	
	               

	if(document.getElementById("i4").value == "" ||!((document.getElementById("i4").value).length==11))	
	   {
               document.getElementById("i4").style.borderColor='red';
	    	x=x+1;
	   }
	   else
	   	document.getElementById("i4").style.borderColor='';	
	if(document.getElementById("i5").value == "")	
	   {
               document.getElementById("i5").style.borderColor='red';
               document.getElementById("i6").style.borderColor='red';
	    	x=x+1;
	   }
	   else{
	   	document.getElementById("i5").style.borderColor='';	
	   	document.getElementById("i6").style.borderColor='';	
            }
	if(document.getElementById("i5").value!=document.getElementById("i6").value)
	{
	document.getElementById("i5").style.borderColor='red';
	document.getElementById("i6").style.borderColor='red';
	  x=x+1;
	}
	else {
            if(!(document.getElementById("i5").value == "" && document.getElementById("i6").value == ""))
            {   
                document.getElementById("i5").style.borderColor='';
                document.getElementById("i6").style.borderColor='';
            }
        }
	if (x==0) 
    	return true;
	else return false;

}





function letternumber(event)
{
    var keychar;
			
    keychar = event.key;
		//alert(event.key)	
		
		// alphas and numbers
    if (((".+-0123456789").indexOf(keychar) > -1) && ((document.getElementById("i4").value).length <=10))
	return true;
    else
        return false;
}

function validate2(){
        let x=0;
    
    if ( document.getElementById("i3").value == "" )
	    {
	    	document.getElementById("i3").style.borderColor='red';	
			x=x+1;		
	    }
	else
	    document.getElementById("i3").style.borderColor='';
    if(document.getElementById("i5").value == "")	
	   {
               document.getElementById("i5").style.borderColor='red';
	    	x=x+1;
	   }
	   else{
	   	document.getElementById("i5").style.borderColor='';	
            }
           if (x==0) 
    	return true;
	else return false; 
            
    
        
}



function validate3()
{	
	let x=0;

	if ( document.getElementById("i1").value == "" )
	    {
	    	document.getElementById("i1").style.borderColor='red';
		x=x+1;		
	    }
	else
	    document.getElementById("i1").style.borderColor='';	
	    
	if ( document.getElementById("i2").value == "" )
	    {
	    	document.getElementById("i2").style.borderColor='red';	
		x=x+1;		
	    }
	else
	    document.getElementById("i2").style.borderColor='';	
	    
	if ( document.getElementById("i3").value == "" )
	    {
	    	document.getElementById("i3").style.borderColor='red';	
			x=x+1;		
	    }
	else
	    document.getElementById("i3").style.borderColor='';	
	               

	if(document.getElementById("i4").value == "" ||!((document.getElementById("i4").value).length==11))	
	   {
               document.getElementById("i4").style.borderColor='red';
	    	x=x+1;
	   }
	   else
	   	document.getElementById("i4").style.borderColor='';	
	if(document.getElementById("i5").value == "")	
	   {
               document.getElementById("i5").style.borderColor='red';
               document.getElementById("i6").style.borderColor='red';
	    	x=x+1;
	   }
	   else{
	   	document.getElementById("i5").style.borderColor='';	
	   	document.getElementById("i6").style.borderColor='';	
            }
	if(document.getElementById("i5").value!=document.getElementById("i6").value)
	{
	document.getElementById("i5").style.borderColor='red';
	document.getElementById("i6").style.borderColor='red';
	  x=x+1;
	}
	else {
            if(!(document.getElementById("i5").value == "" && document.getElementById("i6").value == ""))
            {   
                document.getElementById("i5").style.borderColor='';
                document.getElementById("i6").style.borderColor='';
            }
        }
        if ( document.getElementById("i7").value == "" )
	    {
	    	document.getElementById("i7").style.borderColor='red';	
			x=x+1;		
	    }
	else
	    document.getElementById("i7").style.borderColor='';
        
        if ( document.getElementById("i8").value == "" )
	    {
	    	document.getElementById("i8").style.borderColor='red';	
			x=x+1;		
	    }
	else
	    document.getElementById("i8").style.borderColor='';
	if (x==0) 
    	return true;
	else return false;

}

function validate4(){
  
    if ( document.getElementById("t2").value == "" )
	    {
	    	document.getElementById("t2").style.borderColor='red';	
			return false;		
	    }
	else
            return true;

    
}
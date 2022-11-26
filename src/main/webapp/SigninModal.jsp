<!-- <div class="lineUp backdrop invisible" id="signin-modal" tabindex="-1" role="dialog" aria-labelledby="signin-heading" aria-hidden="true"> -->
<!--     <div class="modal-dialog modal-dialog-centered" role="document"> -->
<!--         <div class="modal-content"> -->
<!--             <div class="modal-header"> -->
<!--                 <h5 class="modal-title" id="signin-heading">SignIn with Shop</h5> -->
<!--                 <button type="button" class="btn btn-primary" id="closeIcon"> -->
<!--                     <span aria-hidden="true">&times;</span> -->
<!--                 </button> -->
<!--             </div> -->

<!--             <div class="modal-body"> -->
<!--  <form action="newUser" method="post"> -->

<!--                 <div class="form-outline mb-4"> -->
<!--                   <input type="text" id="form3Example1cg" class="form-control form-control-lg" /> -->
<!--                   <label class="form-label" for="form3Example1cg">Your Name</label> -->
<!--                 </div> -->

<!--                 <div class="form-outline mb-4"> -->
<!--                   <input type="email" id="form3Example3cg" class="form-control form-control-lg" /> -->
<!--                   <label class="form-label" for="form3Example3cg">Your Email</label> -->
<!--                 </div> -->

<!--                 <div class="form-outline mb-4"> -->
<!--                   <input type="password" id="form3Example4cg" class="form-control form-control-lg" /> -->
<!--                   <label class="form-label" for="form3Example4cg">Password</label> -->
<!--                 </div> -->

<!--                 <div class="form-outline mb-4"> -->
<!--                   <input type="password" id="form3Example4cdg" class="form-control form-control-lg" /> -->
<!--                   <label class="form-label" for="form3Example4cdg">Repeat your password</label> -->
<!--                 </div> -->
<!--               </form> -->
<!--             </div> -->

<!--             <div class="modal-footer"> -->
<!--                 <span> -->
<!--             <button id="alreadyHaveAccount" class="btn btn-block btn-primary">Click Here For Existing Account</button> -->
<!--                 </span> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->


<div class="lineUp backdrop invisible" id="signin-modal" tabindex="-1" role="dialog" aria-labelledby="signin-heading" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="signin-heading">SignIn with My Piece Store</h5>
                <button type="button" class="btn btn-primary" id="closeIcon">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
			 <form action="newUser" method="post">
               <div class="form-outline mb-4">
                <input type="text" name="full_name" id="full_name" class="form-control" />
                <label class="form-label">Full Name</label>
              </div>
 
              <div class="form-outline mb-4">
                <input type="email" name="email" id="email" class="form-control" />
                <label class="form-label">Email address</label>
              </div>
             <div class="form-outline mb-4">
              <input type="text" name="phoneNumber" id="phoneNumber" pattern="[789][0-9]{9}">
              <label class="form-label">Enter Phone Number</label>
               </div>
              <div class="form-outline mb-4">
                <input type="password" name="createPassword" id="createPassword" class="form-control validate" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required/>
                <label class="form-label">Password</label>
                <input type="checkbox" onclick="myFunction()">Show Password 
              </div>              
              <button type="submit" id="submitButton" class="btn btn-primary btn-block mb-4">
                Sign up
              </button>
            </form>    
            </div>
<div id="message">
  <h5>Password must contain the following:</h5>
   <h6 id="letter" class="invalid">A <b>lowercase</b> letter</h6>
  <h6 id="capital" class="invalid">A <b>capital (uppercase)</b> letter</h6>
  <h6 id="number" class="invalid">A <b>number</b></h6>
  <h6 id="length" class="invalid">Minimum <b>8 characters</b></h6>
</div>            

            <div class="modal-footer">
                <span>
            <button id="alreadyHaveAccount" class="btn btn-block btn-primary">Click Here For Existing Account</button>
                </span>
            </div>
        </div>
    </div>
</div>

<div class="lineUp backdrop invisible" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-heading" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="login-heading">Login with My Piece Store</h5>
                <button type="button"  id="closeIcon__login" class="btn btn-primary">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form id="login-form" class="form" role="form" method="post" action="Auth">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        </div>
                        <input type="text" class="form-control" name="login__fullName" placeholder="Full Name" required>
                    </div>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>                        </div>
                        <input type="password" class="form-control" name="login__password" placeholder="Password" minlength="8" required>
                    </div>
                    <div class="form-group">
                        <button type="submit" id="login__submitModal" value="Login" class="btn btn-block btn-primary">Login</button>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <span>
            <button id="toRegisterNewAccount" class="btn btn-block btn-primary">Click Here</button>
                    to register a new account
                </span>
            </div>
        </div>
    </div>
</div>

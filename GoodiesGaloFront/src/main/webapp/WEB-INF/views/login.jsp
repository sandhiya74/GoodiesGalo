<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="script" href="js/jquery-3.4.1.min">
        <link rel="script" href="js/bootstrap.min.js">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
        
        <style>
          * {
    font-family: Arial, Verdana, sans-serif;
    margin: 0px;
    padding: 0px;
    text-decoration: none;
    list-style: none;
    -webkit-tap-highlight-color: transparent;
}

*::selection {
    background-color: rgb(240, 93, 142);
}



body, html {
    margin: 0;
    padding: 0;
    height: 100%;
    background-image: url("images/wall6.jpg");!important;
    overflow-x: hidden;
    min-height: 100%;
    user-select: none;
}

.user_card {
    height: 400px;
    width: 350px;
    margin-top: auto;
    margin-bottom: auto;
    background:rgb(243, 193, 201);
    position: relative;
    display: flex;
    justify-content: center;
    flex-direction: column;
    padding: 10px;
    border-radius: 8px;
    border-style: solid;
  border-width: 5px;
  border-color:rgb(230, 87, 134);
  box-shadow: 0 0 0 0 !important;
  outline: 0 0 0 0  !important;
    border-radius: 5px;

}
/*  */
.brand_logo {
    height: 150px;
    width: 150px;
    border-radius: 50%;
    border: 2px solid white;
}
.form_container {
    margin-top: 30px;
}
h1 {
    font-weight: bold;
    font-size: 43px;
    font-style:italic;
}

.logo {
    width: 40px;
}

.login_btn {
    width: 100%;
    background: brown !important;
    color: white !important;
    font-style:italic;
}

.login_btn:hover {
    background: brown !important;
    color: white !important;
    box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -webkit-box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    -moz-box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    
}

.login_btn:active {
    width: 100%;
    background: #353535 !important;
    color: white !important;
}

.login_btn:focus {
    box-shadow: none !important;
    outline: 0px !important;
}

.input-group-text {
    background: brown !important;
    color: white !important;
    border: 0 !important;
    border-radius: 0.25rem 0 0 0.25rem !important;
}
.input_user,
.input_pass:focus {
    box-shadow: none !important;
    outline: 0px !important;
}


.custom-checkbox .custom-control-input:checked~.custom-control-label::before {
    background-color: brown!important;
}

.groupe-liens {
    margin-top: 15px;
}

.liens {
    color: brown;
    font-style:italic;
}

.liens:hover {
    color: #353535;
    font-style:italic;
}

        </style>
        
        <body>
          <div class="container h-100">
            <div class="d-flex justify-content-center h-100">
                <div class="user_card">
                    <div class="d-flex justify-content-center" style="color:brown">
                        <h1>LOGIN</h1>
                    </div>
                    <div class="d-flex justify-content-center form_container">
                        <form>
                            <div class="input-group mb-3">
                                
                                <input type="text" name="" class="form-control input_user" value="" placeholder="username" spellcheck="false">
                            </div>
                            <div class="input-group mb-2">
                                
                                <input type="password" name="" class="form-control input_pass" value=""
                                    placeholder="password" spellcheck="false">
                            </div>
                            <div class="d-flex justify-content-center mt-3 login_container">
                                <button type="button" name="button" class="btn login_btn">Login</button>
                            </div>
                        </form>
                    </div>
    
                    <div class="mt-4 groupe-liens">
                        <div class="d-flex justify-content-center links">
                            Don't have an account? <a href="#" class="ml-2 liens">Sign Up</a>
                        </div>
                        <div class="d-flex justify-content-center links">
                            <a href="#" class="liens">Forgot your password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
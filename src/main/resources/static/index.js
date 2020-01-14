function getValue() {
    let checks = document.getElementsByClassName('posn');
    arr = [];
    let posn_id = {};
    let str = '';
    for ( i = 0; i < 15; i++) {
        if ( checks[i].checked === true ) {

            str = checks[i].value;
            str = parseInt(str,10);
            let position_data =     
            {
                id: str
            }
        
        arr.push(position_data);    
        }
                        
        }
   

    console.log(arr)
}


function sendPlayerData(){
    let checks = document.getElementsByClassName('posn');
    arr = [];
    let posn_id = {};
    let str = '';
    for ( i = 0; i < 15; i++) {
        if ( checks[i].checked === true ) {

            str = checks[i].value;
            str = parseInt(str,10);
            let position_data =     
            {
                id: str
            }
        
        arr.push(position_data);    
        }
                        
        }
   

    console.log(arr)

   
    let playerInfo = {

            firstName: document.getElementById('firstName').value,
            lastName: document.getElementById('lastName').value,
            age: document.getElementById('age').value,
            typeOfInjury: document.getElementById('typeOfInjury').value,
            lengthOfInjury: document.getElementById('lengthOfInjury').value,
            timePeriod: document.getElementById('timePeriod').value,
            positions: arr
            
    
        };
        
        JSON.stringify(playerInfo);
        axios.post('http://localhost:8080/player/create', playerInfo)
        .then(function (response){ 

            console.log(response);
        
        })
        .catch(function (error){
    
            console.log(error);


     })
     
    }     

// function sendPositionData(){
//     let checks = document.getElementsByClassName('posn');
//     let str = '';
//     for ( i = 0; i < 15; i++) {
//         if ( checks[i].checked === true ) {
//             str += checks[i].value + " ";
//         }
//     }

//     let positionInfo = {
//         position: str
//     };
//     JSON.stringify(positionInfo);
//     axios.post('http://localhost:8080/position/create',positionInfo)
//     .then(function (response){ 

//         console.log(response);
    
//     })
//     .catch(function (error){

//         console.log(error);


//  })
 
// }

function validateForm(){
    let hasNumber = /\d/;
    let fn = document.playerInputData.firstName.value;
    let ln = document.playerInputData.lastName.value;
    let age = document.playerInputData.age.value;
    // let posn = document.playerInputData.position.value;
    let DoI = document.playerInputData.typeOfInjury.value;
    let LoI = document.playerInputData.lengthOfInjury.value;
    let TP = document.playerInputData.timePeriod.value;
    
    //First Name Validation
    if(fn == "") {
        alert( "Please Enter a First Name" );
        document.playerInputData.firstName.focus();
        document.getElementById('firstName').style.backgroundColor = "#f54c4c";
        return false;
    }
    if( hasNumber.test(fn)) {
         alert( "Error - Name Cannot Contain Numbers" );
         document.playerInputData.firstName.focus() ;
         document.getElementById('firstName').style.backgroundColor = "#f54c4c";
         return false;
    }
    if( fn.length < 2 ) {
        alert( "First Name Too Short" );
        document.playerInputData.firstName.focus();
        document.getElementById('firstName').style.backgroundColor = "#f54c4c";
        return false;
    }
    if( fn.length > 200 ) {
        alert( "First Name Too Long" );
        document.playerInputData.firstName.focus();
        document.getElementById('firstName').style.backgroundColor = "#f54c4c";
        return false;
    }
    // if(fn){
    //     alert( "Name cannot contain Special Characters" );
    //     document.playerInputData.firstName.focus();
    //     document.getElementById('firstName').style.backgroundColor = "#f54c4c";
    //     return false;
    // }


    //Last Name Validations
     if(  ln == "" ) {
        alert( "Please Enter a Last Name" );
        document.playerInputData.lastName.focus();
        document.getElementById('lastName').style.backgroundColor = "#f54c4c";
        return false;
    }
    if( hasNumber.test(ln)) {
         alert( "Error - Last Name cannot contain numbers" );
         document.playerInputData.lastName.focus() ;
         document.getElementById('lastName').style.backgroundColor = "#f54c4c";
         return false;
    }
     if( ln.length < 2 ) {
        alert( "Last Name Too Short" );
        document.playerInputData.lastName.focus();
        document.getElementById('lastName').style.backgroundColor = "#f54c4c";
        return false;
    }
     if( ln.length > 200 ) {
        alert( "Last Name Too Long" );
        document.playerInputData.lastName.focus();
        document.getElementById('lastName').style.backgroundColor = "#f54c4c";
        return false;
    }
    
    //Age Validations
    if(age == "" ) {
        alert( "Please Enter an Age" );
        document.playerInputData.age.focus();
        document.getElementById('age').style.backgroundColor = "#f54c4c";
        return false;
    }
    if(age < 1 || age > 120){
        alert( "Age Must be Greater than 1 and less than 120" );
        document.playerInputData.age.focus();
        document.getElementById('age').style.backgroundColor = "#f54c4c";
        return false;
    }

   
     //Description of Injury Validation
     if(DoI == "") {
        alert( "Please Enter a Description of the Injury" );
        document.playerInputData.typeOfInjury.focus();
        document.getElementById('typeOfInjury').style.backgroundColor = "#f54c4c";
        return false;
    }

     if( hasNumber.test(DoI)) {
        alert( "Error - Description cannot contain numbers" );
        document.playerInputData.typeOfInjury.focus();
        document.getElementById('typeOfInjury').style.backgroundColor = "#f54c4c";
        return false;
    }

    if(DoI.length ==1 || DoI.length >= 150 ){
        alert( "Error - Description must be between 1 and 150 Characters" );
        document.playerInputData.typeOfInjury.focus();
        document.getElementById('typeOfInjury').style.backgroundColor = "#f54c4c";
        return false;
    }

    //Length Of Injury Validation
    if(LoI == "" ) {
        alert( "Please Enter a Length Of Injury" );
        document.playerInputData.lengthOfInjury.focus();
        document.getElementById('lengthOfInjury').style.backgroundColor = "#f54c4c";
        return false;
    }
    if(LoI < 1){
        alert( "Length of Injury Must be Greater than 1" );
        document.playerInputData.lengthOfInjury.focus();
        document.getElementById('lengthOfInjury').style.backgroundColor = "#f54c4c";
        return false;
    }
    if(TP == "Choose a Time Period"){
        alert( "How long will the player be out for?" );
        document.playerInputData.timePeriod.focus();
        return false;
    }
    
 


}


function getPlayerData(){

    pData = axios.get('http://localhost:8080/player/getAll')
    .then(function (response){ 

        console.log(response);
        addDataToTable(response.data)
    
    })
    .catch(function (error){

        console.log(error);


 });
}

const date = new Date();
function addDays(date, days) {
    const copy = new Date(Number(date))
    copy.setDate(date.getDate() + days)
    return copy
}

const table = document.getElementById("playerTable");
function addDataToTable(dataToAdd){
    for(let playerData of dataToAdd){

        let row = document.createElement("tr");
        let firstNameEntry = document.createElement("td")
        firstNameEntry.innerHTML = playerData.firstName;
        row.appendChild(firstNameEntry);

        let lastNameEntry = document.createElement("td");
        lastNameEntry.innerHTML = playerData.lastName;
        row.appendChild(lastNameEntry);

        let ageEntry = document.createElement("td");
        ageEntry.innerHTML = playerData.age;
        row.appendChild(ageEntry);

        let positionEntry = document.createElement("td");      
        let result = '';
        for(let i = 0; i < playerData.positions.length; i++ ){

            let a = playerData.positions;
            let b = a[i];
            
            result += b.position + ",";
            
            
        }
        positionEntry.innerHTML = result;
        row.append(positionEntry);

        let typeOfInjuryEntry = document.createElement("td");
        typeOfInjuryEntry.innerHTML = playerData.typeOfInjury;
        row.append(typeOfInjuryEntry);

        let lengthOfInjuryEntry = document.createElement("td");
        lengthOfInjuryEntry.innerHTML = playerData.lengthOfInjury + " " + playerData.timePeriod;
        row.append(lengthOfInjuryEntry);

        let roughReturnDateEntry = document.createElement("td");
        if( playerData.timePeriod == "Days"){
            
            let newDate = addDays(date, playerData.lengthOfInjury);
            roughReturnDateEntry.innerHTML = newDate;
            row.append(roughReturnDateEntry);

        
          }else if(playerData.timePeriod == "Weeks"){
            
            let weekToDay = playerData.lengthOfInjury * 7;    
            let newDate = addDays(date, weekToDay);
            roughReturnDateEntry.innerHTML = newDate;
            row.append(roughReturnDateEntry);
            
        
        
          }else if(playerData.timePeriod == "Months"){
            
            let monthToDay = playerData.lengthOfInjury * 28;
            let newDate = addDays(date, monthToDay);
            roughReturnDateEntry.innerHTML = newDate;
            row.append(roughReturnDateEntry);
        
          }
       
        

        table.appendChild(row);
          

    }





}


 
 














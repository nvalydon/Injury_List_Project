function sendPlayerData(){
    let checks = document.getElementsByClassName('posn');
    arr = [];
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
        
              
         if(validateForm() != false){   

        axios.post('/InjuryApp/player/create', playerInfo)
        .then(function (response){
            
            console.log('data posted!')
            console.log(response);
        
        })
        .catch(function (error){
    
            console.log(error);


     })
     
    }     
}

function validateForm(){
    let hasNumber = /\d/;
    let fn = document.playerInputData.firstName.value;
    let ln = document.playerInputData.lastName.value;
    let age = document.playerInputData.age.value;
    let DoI = document.playerInputData.typeOfInjury.value;
    let LoI = document.playerInputData.lengthOfInjury.value;
    
    
    
    //First Name Validation
    if(fn == "") {
        alert( "Please Enter a First Name" );
        document.playerInputData.firstName.focus();
        document.getElementById('firstName').style.backgroundColor = "#f54c4c";
        return false;
    }
    if(hasNumber.test(fn)) {
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
   
    
}

function validateFormEdit(){
    let hasNumber = /\d/;
    let fn = document.getElementById("firstNameEdit").value;
    let ln = document.getElementById("lastNameEdit").value;
    let age = document.getElementById("ageEdit").value;
    let LoI = document.getElementById("LOIEdit").value;
    let DoI = document.getElementById("DOI").value;
    
    
    
    //First Name Validation
    if(fn == "") {
        alert( "Please Enter a First Name" );
        document.playerInputData.firstName.focus();
        document.getElementById('firstName').style.backgroundColor = "#f54c4c";
        return false;
    }
    if(hasNumber.test(fn)) {
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
    //Time Period Validation
    let daySelected = document.getElementById('days').checked
    let weekSelected = document.getElementById('weeks').checked
    let monthSelected = document.getElementById('months').checked

    if(!daySelected && !weekSelected && !monthSelected ) { 
        alert("Please Select a time Period")    
        
        return false
    }


}

function getPlayerData(){

    pData = axios.get('/InjuryApp/player/getAll')
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
    let dd = copy.getDate();
    let mm = copy.getMonth() + 1;
    let yyyy = copy.getFullYear();
    const monthNames = ["January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"];

    let monthToString = monthNames[copy.getMonth()]

    if (dd < 10) {
    dd = '0' + dd;
    } 
    if (mm < 10) {
    mm = '0' + mm;
    } 
    let newDate = dd + '  ' + monthToString + '  ' + yyyy;

    return newDate 
}

function deletePlayer(id){

    axios.delete('/InjuryApp/player/delete/' + id)
    .then(function (response){ 

        console.log(response);
        
    
    })
    .catch(function (error){

        console.log(error);


 });




}

let table = document.getElementById("playerTable");
function addDataToTable(dataToAdd){
    
    for(let playerData of dataToAdd){
        let playerNum = playerData.id
        let row = document.createElement("tr");

        let firstNameEntry = document.createElement("td")
        firstNameEntry.id = "firstNameCell" + playerNum; 
        firstNameEntry.innerHTML = playerData.firstName;
        row.appendChild(firstNameEntry);

        let lastNameEntry = document.createElement("td");
        lastNameEntry.id = "lastNameCell" + playerNum;
        lastNameEntry.innerHTML = playerData.lastName;
        row.appendChild(lastNameEntry);

        let ageEntry = document.createElement("td");
        ageEntry.id = "ageCell" + playerNum;
        ageEntry.innerHTML = playerData.age;
        row.appendChild(ageEntry);

        let positionEntry = document.createElement("td");      
        let result = '';
        for(let i = 0; i < playerData.positions.length; i++ ){

            let a = playerData.positions;
            let b = a[i];
            
            result += b.position + ",";
            
            
        }
        positionEntry.id = "positionCell" + playerNum;
        positionEntry.innerHTML = result;
        row.append(positionEntry);

        let typeOfInjuryEntry = document.createElement("td");
        typeOfInjuryEntry.id = "typeOfInjuryCell" + playerNum;
        typeOfInjuryEntry.innerHTML = playerData.typeOfInjury;
        row.append(typeOfInjuryEntry);

        let lengthOfInjuryEntry = document.createElement("td");
        lengthOfInjuryEntry.id = "lengthOfInjuryCell" + playerNum;

        
        lengthOfInjuryEntry.innerHTML = playerData.lengthOfInjury + " " + playerData.timePeriod;
        //lengthOfInjuryEntry.innerHTML = playerData.timePeriod.disabled
        row.append(lengthOfInjuryEntry);

        let roughReturnDateEntry = document.createElement("td");
        if( playerData.timePeriod == "Days"){
            
            let newDate = addDays(date, playerData.lengthOfInjury);
            roughReturnDateEntry.id = "roughReturnDateCell" + playerNum
            roughReturnDateEntry.innerHTML = newDate;
            row.append(roughReturnDateEntry);

        
          }else if(playerData.timePeriod == "Weeks"){
            
            let weekToDay = playerData.lengthOfInjury * 7;    
            
            let newDate = addDays(date, weekToDay);
            roughReturnDateEntry.id = "roughReturnDateCell" + playerNum
            roughReturnDateEntry.innerHTML = newDate;
            row.append(roughReturnDateEntry);
            
        
        
          }else if(playerData.timePeriod == "Months"){
            
            let monthToDay = playerData.lengthOfInjury * 30.417;
            let newDate = addDays(date, monthToDay);
            roughReturnDateEntry.id = "roughReturnDateCell" + playerNum
            roughReturnDateEntry.innerHTML = newDate;
            row.append(roughReturnDateEntry);
        
          }
       
         

          let updateButton = document.createElement("button");       
          updateButton.id = "updateButton" + playerNum;
          updateButton.innerHTML = "Update";
          updateButton.addEventListener('click', ()=> {let result = confirm("Do you Want to Update this player?");
          if(result){
            updateButton.hidden = true;  
            editRow(playerData.id)
            confirmButton.hidden =false; 
                         
          }});

        row.append(updateButton);
        
          let confirmButton = document.createElement("button");
          confirmButton.innerHTML= "Confirm"
          confirmButton.hidden = true;
          confirmButton.addEventListener('click', ()=> updatePlayer(playerData.id) & document.location.reload())
          row.append(confirmButton);


        let deleteCol = document.createElement("td");
        let deleteButton = "&#128465";
        deleteCol.innerHTML = deleteButton;
        row.append(deleteCol);
        deleteCol.addEventListener('click', ()=> {let result = confirm("Do you Want to Delete this player?")
        if(result){deletePlayer(playerData.id)
            window.location.reload(true)
        }});
      
        table.appendChild(row);
          

    }

    
}

function editRow(id){
    
    let firstNameUpdate = document.getElementById("firstNameCell" + id)
    let firstNameVal = firstNameUpdate.innerHTML;
    firstNameUpdate.innerHTML ="<input id=firstNameEdit class=firstNameEdit type=text value='"+firstNameVal+"'>";

    let lastNameUpdate = document.getElementById("lastNameCell" + id)
    let lastNameVal = lastNameUpdate.innerHTML;
    lastNameUpdate.innerHTML = "<input id=lastNameEdit class=lastNameEdit type=text value='"+lastNameVal+"'>";

    let ageUpdate = document.getElementById("ageCell" + id)
    let ageVal = ageUpdate.innerHTML;
    ageUpdate.innerHTML = "<input id=ageEdit class=ageEdit type=number min=1 max=120 value='"+ageVal+"'>";

    let positionUpdate = document.getElementById("positionCell" + id)
    let positionVal = positionUpdate.innerHTML;

    positionUpdate.innerHTML = "<input class=posnEdit type=checkbox value=1>CF" + "<input class=posnEdit type=checkbox value=2 >ST" + "<input class=posnEdit type=checkbox value=3>RW" + "<input class=posnEdit type=checkbox value=4>LW" + "</br>" +
                               "<input class=posnEdit type=checkbox value=5>RM" + "<input class=posnEdit type=checkbox value=6 >LM" + "<input class=posnEdit type=checkbox value=7>CM" + "<input class=posnEdit type=checkbox value=8>CAM" + "<input class=posnEdit type=checkbox value=9>CDM" + "</br>" +
                               "<input class=posnEdit type=checkbox value=10>CB" + "<input class=posnEdit type=checkbox value=11 >LB" + "<input class=posnEdit type=checkbox value=12>RB" + "<input class=posnEdit type=checkbox value=13>LWB" + "<input class=posnEdit type=checkbox value=14>RWB" + "</br>" + 
                               "<input class=posnEdit type=checkbox value=15>GK"
    
    
    
    let lengthOfInjuryUpdate = document.getElementById("lengthOfInjuryCell" + id)
    let lengthOfInjuryVal = lengthOfInjuryUpdate.innerHTML
    let LOIArray = lengthOfInjuryVal.split(' ');
    let LOINum = LOIArray[0]
    

        lengthOfInjuryUpdate.innerHTML = "<input id=LOIEdit class=LOIEdit type=number min=1 value='"+LOINum+"'>" + "<br/>"
                                        + '<input id=days   class=TPEdit type="radio" name="TP" value="' + "Days" + '">Days' 
                                        + '<input id=weeks  class=TPEdit type="radio" name="TP" value="' + "Weeks" + '"> Weeks' 
                                        + '<input id=months class=TPEdit type="radio" name="TP" value="' + "Months" + '"> Months';
    



    let descOfInjuryUpdate = document.getElementById("typeOfInjuryCell" + id)
    let descOfInjuryVal = descOfInjuryUpdate.innerHTML;

    descOfInjuryUpdate.innerHTML = "<input id=DOI class=descriptionEdit type=text value='"+descOfInjuryVal+"'>";
}

function updatePlayer(id){

    let checks = document.getElementsByClassName('posnEdit');
    arr = [];
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

    let checkedValue
    if(document.getElementById("days").checked){
         checkedValue = document.getElementById("days").value 
        
    }else if(document.getElementById("weeks").checked){
         checkedValue = document.getElementById("weeks").value 
        
    }else if(document.getElementById("months").checked){
         checkedValue = document.getElementById("months").value 
        
    }




    let playerInfo = {

        firstName: document.getElementById('firstNameEdit').value,
        lastName: document.getElementById('lastNameEdit').value,
        age: document.getElementById('ageEdit').value,
        typeOfInjury: document.getElementById('DOI').value,
        lengthOfInjury: document.getElementById('LOIEdit').value,
        timePeriod: checkedValue,
        positions: arr
                

    };



    JSON.stringify(playerInfo);

    if(validateFormEdit() != false){

        axios.put('/InjuryApp/player/update/' + id, playerInfo)
        .then(function (response){ 

            console.log(response);
        
        })
        .catch(function (error){
    
            console.log(error);


     })

     
}else{

    alert("Update Unsuccessful")

}
}

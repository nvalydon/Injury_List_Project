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

// function getPlayerDataForUpdate(id){

//      let pData = axios.get('http://localhost:8080/player/get/' + id)
//     .then(function(response){ 
//                         document.getElementById("firstName").innerHTML = pData.firstName;
//         console.log(response);
        
//     })
//     .catch(function (error){

//         console.log(error);

//  });
// }

// function playerToBeupdated(){
// console.log("test")
// // for(key in pData){
// //             if(pData.hasOwnProperty(key))
// //             console.log(key)
// //             $('input[name='+key+']'.valueOf(pData[key]))
// //         }

// // document.getElementById("firstName").innerHTML = 



//}



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


function deletePlayer(id){

    axios.delete('http://localhost:8080/player/delete/' + id)
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

        //let timePeriodEntry = document.createElement("td").disabled
        // let TP = playerData.timePeriod
        // TP.id = "timePeriod" + playerNum;
        // console.log([playerData.timePeriod.id])
        lengthOfInjuryEntry.innerHTML = playerData.lengthOfInjury + " " + playerData.timePeriod;
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
       
          let updateCol = document.createElement("td");
          let updateButton = "Click Here  ";
          updateCol.innerHTML = updateButton;
          row.append(updateCol);
          updateCol.addEventListener('click', ()=> {let result = confirm("Do you Want to Update this player?")
          if(result){editRow(playerData.id)
                         
          }});
        

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
    
    //console.log(pData)
    let table = document.getElementById("playerTable")

    let firstNameUpdate = document.getElementById("firstNameCell" + id)
    let firstNameVal = firstNameUpdate.innerHTML;

    firstNameUpdate.innerHTML ="<input type=text value='"+firstNameVal+"'>";

    let lastNameUpdate = document.getElementById("lastNameCell" + id)
    let lastNameVal = lastNameUpdate.innerHTML;

    lastNameUpdate.innerHTML = "<input type=text value='"+lastNameVal+"'>";

    let ageUpdate = document.getElementById("ageCell" + id)
    let ageVal = ageUpdate.innerHTML;

    ageUpdate.innerHTML = "<input type=number value='"+ageVal+"'>";

    // let positionUpdate = document.getElementById("positionCell" + id)
    // let positionVal = positionUpdate.innerHTML;

    //console.log("positionCell" + id)

    //positionUpdate.innerHTML = "<input type=checkbox value="+positionVal+"'>"

    let lengthOfInjuryUpdate = document.getElementById("lengthOfInjuryCell" + id)
    let lengthOfInjuryVal = lengthOfInjuryUpdate.innerHTML;

    lengthOfInjuryUpdate.innerHTML = "<input type=number value='"+lengthOfInjuryVal+"'>"



    let descOfInjuryUpdate = document.getElementById("typeOfInjuryCell" + id)
    let descOfInjuryVal = descOfInjuryUpdate.innerHTML;

    descOfInjuryUpdate.innerHTML = "<input type=text value='"+descOfInjuryVal+"'>";



}


<?php
  function read($id,$Connection){
    $readData = $Connection->query("SELECT * FROM user_commit_schedule where commit_schedule_user_id = $id");
    $doJson = [];
    while($readOutputUser = $readData->fetch_assoc()){
      array_push($doJson,$readOutputUser);
    }
    echo json_encode($doJson);
  }

  class reader{
    function schedule(){
      
    }
  }
 ?>

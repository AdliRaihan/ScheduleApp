<?php
  function read($id,$Connection){
    $readData = $Connection->query("SELECT * FROM user_schedule");
    $doJson = [];
    while($readOutputUser = $readData->fetch_assoc()){
      array_push($doJson,$readOutputUser);
    }
    echo json_encode($doJson);
  }
 ?>

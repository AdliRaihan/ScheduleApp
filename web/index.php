<?php
  require_once 'server/server_connection.php';

  //Data class
  $DefaultUri = "/schedule_app";
  $readWho = "1";
  if(isset($_GET['do']) && isset($_GET['id'])){
    require 'schedule.php';
    read($_GET['id'],$Connection);
  }else if(isset($_GET['do']) && isset($_GET['id'])){

  }else{
    require_once "pages/linked_assets.html";
    require_once "pages/index.html";
  }
  class DatabaseFunction{

  }

 ?>

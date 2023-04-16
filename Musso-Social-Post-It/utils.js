function CreaPostIt(Nome, Descrizione)
{
    return '<div class="postIt">'+
        '<div class="d-sm-block">'+
    '<div class="col-xs">'+
      '<div class=topBar></div>'+
      '<div class=form>'+
        '<div contenteditable class=textAria  id="Div1">'+
            'nome: '+Nome+'<br>'+
            'descrizione: '+Descrizione+'<br>'+
        '</div>'+
      '</div>'+
      '</div>'+
      '</div>'+
    '</div>';  
}


function memorizzaPostIt(Nome, Descrizione)
{
  const fs=require('fs');
  var data=JSON.parse(fs.readFileSync('PostIt.json', 'utf8'));
  data.push({nome: Nome, descrizione: Descrizione});
  fs.writeFileSync('PostIt.json', JSON.stringify(data));
}

function LeggiPostIt()
{
  var inizioPostIt='<!DOCTYPE html>'+
   '<HTML><BODY>'+'<head>'+
    '<link rel="stylesheet" href="style/bootstrap.css">'+
    '<link rel="stylesheet" href="style/PostIt.css">'+
  '</head>'+
   '<FORM method="post" ACTION="/risposta">';
  var finePostIt='</FORM>'+
   '</BODY></HTML>';
  const fs=require('fs');
  var PostItJSON=fs.readFileSync('PostIt.json');
  let PostIt = JSON.parse(PostItJSON);
  var nomi = PostIt.map(arraynomi => arraynomi.nome);
  var descrizioni=PostIt.map(arraydescrizioni => arraydescrizioni.descrizione);
  var nuoviDiv="";
  for(var i=1; i<nomi.length; i++)
  {
    nuoviDiv=nuoviDiv+CreaPostIt(nomi[i], descrizioni[i]);
  }
  return inizioPostIt+nuoviDiv+finePostIt;
}



module.exports={CreaPostIt:CreaPostIt, memorizzaPostIt:memorizzaPostIt, LeggiPostIt:LeggiPostIt};
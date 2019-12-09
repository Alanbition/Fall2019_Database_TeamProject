
const app = document.getElementById('root')

const container = document.createElement('div')
container.setAttribute('class', 'container')

app.appendChild(container)
var searchTerm = document.querySelector('.search');
console.log(searchTerm.value);
var request = new XMLHttpRequest()
request.open('GET', 'https://authenticjobs.com/api/?api_key=e9d6324e7773666093c5dfa0b4212ff0&format=json&method=aj.jobs.search&keywords='+searchTerm.value, true)
request.onload = function() {
  // Begin accessing JSON data here
  response = JSON.parse(this.response)
  console.log(response['listings']);
  //console.log(response);
  data = response.listings.listing;
  var keys = Object.keys(data);
  
  if (request.status >= 200 && request.status < 400) {
    
	  for(var i=0;i<data.length;i++){
		  job = data[keys[i]]
	      const card = document.createElement('div')
	      card.setAttribute('class', 'card')
	
	      const h1 = document.createElement('h1')
	      h1.textContent = job.title
	
	      const p = document.createElement('p')
	      job.description = job.description.substring(0, 300)
	      p.textContent = `${job.description}...`
	
	      container.appendChild(card)
	      card.appendChild(h1)
	      //card.appendChild(p)
    }
  } else {
    const errorMessage = document.createElement('marquee')
    errorMessage.textContent = `Gah, it's not working!`
    app.appendChild(errorMessage)
  }
}

request.send()
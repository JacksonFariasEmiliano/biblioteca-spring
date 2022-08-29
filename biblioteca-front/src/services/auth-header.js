export default function authHeader() {
  let user = JSON.parse(localStorage.getItem('user'));

  //formato do token
  if (user && user.accessToken) {
    return { Authorization: 'Bearer ' + user.accessToken }; 
    
  } else {
    return {};
  }
}

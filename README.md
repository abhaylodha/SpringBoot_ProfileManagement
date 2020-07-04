#Chrome JSON viewer Plugin
https://chrome.google.com/webstore/detail/jsonview/chklaanhfefbnpoihckbnefhakgolnmc?hl=en

# Restlet API Chrome extension 
https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=en  

#Enable Basic Authentication and bypassing basic authentication for OPTIONS type of HTTPRequest
##### On Spring Boot Application side -
1) Add configuration in application.properties
	spring.security.user.name=<user>
	spring.security.user.password=<password>

2) In Eclispse Open types -> Ctrl + Shift + t
3) Search for WSCA (WebSecurityConfigurerAdapter)
4) It contains Default Security Configuration.

Locate configure method (-> Ctrl + o) and copy it.	
	Search configure methid with Http as a param.
	Create a new sub package : com.ak.profile_management.basic.auth
	Create a new Class : SpringSecurityConfigurationBasic
		extend class with WebSecurityConfigurerAdapter
		Add class level annotations - @Configuration & @EnableWebSecurity
		Add override to method : configure(HttpSecurity http)
	 	Remove logger.
	 	change :
	 		
	 		http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin().and()
			.httpBasic();
			
		to :
			
			http
			.csrf().disable() // CSRF tokens are disabled from PUT and POST.
			.authorizeRequests()
			// Allow pre-flight requests.
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // All OPTIONS URLs are allowed.
			.anyRequest().authenticated().and().httpBasic();  //Use HTTP basic request.
			
##### On Angular side -
	on Angular side, the get URL changes from
		this.http.get('<url>')
		this.http.put('<url>')
	to
		this.http.get('<url>', headers : new HttpHeaders({Authorization: 'basic ' + window.btoa(<user> + ':' + <password>)}))
		this.http.put('<url>', headers : new HttpHeaders({Authorization: 'basic ' + window.btoa(<user> + ':' + <password>)}))

### Fully working set :
*) Angular GUI : 
https://github.com/abhaylodha/Angular_Common_Project
*) Spring Boot Backend : 
 https://github.com/abhaylodha/SpringBoot_ProfileManagement
 
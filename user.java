@DeleteMapping("delete/{id}")
	public ResponseEntity<user> delete(@PathVariable int id) {
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping(path="/users/{id}")
	public ResponseEntity<user> updateUser(@PathVariable int id,@RequestBody  user usr)
	{
		 if (repo.findById(id).isPresent()){
			 System.out.println("found");
	            user existingUser = repo.findById(id).get();

	            if(usr.getUmail()!=null)
	            existingUser.setUmail(usr.getUmail());
	            if(usr.getUname()!=null)
	            existingUser.setUname(usr.getUname());
	            if(usr.getUnumber()!=null)
	            existingUser.setUnumber(usr.getUnumber());
	            

	            return new ResponseEntity<>(repo.save(existingUser), HttpStatus.OK);
	        }else{
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		
	}

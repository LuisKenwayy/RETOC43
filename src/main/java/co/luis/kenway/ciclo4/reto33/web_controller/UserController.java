package co.luis.kenway.ciclo4.reto33.web_controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.luis.kenway.ciclo4.reto33.Documents.User;
import co.luis.kenway.ciclo4.reto33.exceptions.ResourceNotFoundException;
import co.luis.kenway.ciclo4.reto33.service.UserService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
    RequestMethod.PUT })

/**
 * Reto 2
 * @author: maycol Suarez
 */
public class UserController {

    @Autowired
    /**
     * Se instancia la clase ServiceUser
     * @param UserService nombre de la variable dónde se instancia la clase
     */
    private UserService userService;

    @PostMapping("/new")
    /**
     * Metodo para crear un usuario
     * @param user esste es el usuario que ceara en base de datos
     * *@return me retorna el usuario registrado en base de datos
     */
    public ResponseEntity<User> create(@RequestBody User user){
        try {
            User newUser = userService.create(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED) ;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    /**
     * Metodo para listar usuarios
     * *@return Lista de usuarios
     */
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    /**
     * Metodo para obtener un usuario
     * *@return Lista de usuarios
     */
    public Optional<User> getUserById(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @GetMapping("/emailexist/{email}")
    /**
     * Metodo para validar si un correo existe en bases de datos
     * @param email este es el corre que se envia para validar en bases de datos
     * *@return me retorna true si el usuario existe, de lo contrario retorna un false
     */
    public boolean getUserByEmail(@PathVariable("email") String email){
        return userService.emailExists(email);
    }

    @GetMapping("/{email}/{password}")
    /**
     * Metodo para validar si un usuario existe
     * @param email este es el corre que se envia para validar en bases de datos
     * @param password esta es la contraseña que se envia para validar en bases de datos
     * *@return me retorna el usuario registrado en base de datos
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    // public ResponseEntity<User> validarUser(@PathVariable("email") String email,@PathVariable("password") String password){
    //     try {
    //         User usuarioValido = userService.validarUsuario(email, password);
    //         return new ResponseEntity<>(usuarioValido, HttpStatus.CREATED) ;
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PutMapping("/update")
    /**
     * Metodo para editar un usuario
     * @param user esste es el usuario que se editará en base de datos
     * *@return me retorna el usuario editado en base de datos
     */
    @ResponseStatus(HttpStatus.CREATED)
    // public User update(@RequestBody User user) {
    //     return userService.updateUser(user);
    // }
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try {
            User newUser = userService.updateUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED) ;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id_user}")
    /**
     * Metodo para borrar un usuario
     * @param id este es el usuario que se eliminará en base de datos
     * *@return me retorna un HttpStatus dependiendo si borra o no al usuario
     */
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id_user") int id_user){
        try {
            userService.delete(id_user);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT) ;
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND) ;
        }catch(Exception er){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

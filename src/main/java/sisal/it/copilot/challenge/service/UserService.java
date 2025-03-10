package sisal.it.copilot.challenge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisal.it.copilot.challenge.Exception.EntityNotFoundException;
import sisal.it.copilot.challenge.beans.request.Users;
import sisal.it.copilot.challenge.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Optional<Users> getUserById(Long id) throws EntityNotFoundException{
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id))
        );
    }

    public Users updateUser(Long id, Users userDetails) throws EntityNotFoundException{
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) throws EntityNotFoundException{
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}
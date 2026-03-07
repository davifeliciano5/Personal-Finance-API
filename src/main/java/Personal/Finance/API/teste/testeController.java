package Personal.Finance.API.teste;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class testeController {

    @Autowired
    TesteService testeService;

    @PostMapping
    public ResponseEntity bucarEmail(@RequestBody Long id){

        if(id != null) {
            return ResponseEntity.ok(testeService.buscaEmail(id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity Email(@PathVariable Long id){

        if(id != null) {
            return ResponseEntity.ok(testeService.buscaEmail(id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

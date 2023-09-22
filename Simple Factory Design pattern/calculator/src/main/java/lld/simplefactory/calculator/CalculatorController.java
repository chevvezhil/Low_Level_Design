package lld.simplefactory.calculator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lld.simplefactory.calculator.factory.CalculateFactory;
import lld.simplefactory.calculator.model.CalculatedOperations;
import lld.simplefactory.calculator.service.CalculationService;
import lld.simplefactory.calculator.utill.ICalculateOperation;

@Controller
public class CalculatorController {

	
	@PostMapping("/performCalculation")
	public ResponseEntity<Double> performOperation(@RequestBody Map<String,Object> requestBody) {
		
			String type = (String) requestBody.get("type");
	        int operand1 = (int) requestBody.get("operand1");
	        int operand2 = (int) requestBody.get("operand2");
	        
	        
	        ICalculateOperation addition = CalculateFactory.createOperation(type.toUpperCase());
	        
	        double value = addition.performOperation(operand1, operand2);
	        
	        CalculatedOperations operation = new CalculatedOperations();
	        operation.setOperand1(operand1);
	        operation.setOperand2(operand2);
	        operation.setOperation(type);
	        operation.setResult(value);
	        
	        CalculationService.addOperations(operation);
	        
	        return ResponseEntity.ok(value);
	}
	
	
	@GetMapping("/history")
    public ResponseEntity<List<CalculatedOperations>> getCalculationHistory() {
        return ResponseEntity.ok(CalculationService.getAllOperations());
    }
	
}

package kr.pet.mvc;


import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private MedicalRecordController recordController; // 진료기록을 관리하는 컨트롤러

    public CustomerController(MedicalRecordController recordController){
        this.customers = new ArrayList<>();
        // 회원을 삭제할 때 진료기록을 받아둬야하기 때문에 컨트로러 객체를 생성해둠
        this.recordController = recordController;
    }

    // 고객 정보를 등록하는 메서드
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    // 고객정보를 삭제하는 메서드 (반드시 해당 고객의 진료기록도 함께 삭제)
    public void removeCustomer(String phoneNumber){
        for (int i=0; i<customers.size(); i++){
            if(phoneNumber.equals(customers.get(i).getPhoneNumber())){
                customers.remove(i);
                // 해당 고객의 진료 기록도 함께 삭제하기 위한 컨트롤러 객체
                recordController.removeMedicalRecord(phoneNumber);
                break;
            }
        }
    }

    // 고객등록 여부를 확인하는 메서드
    public Customer findCustomer(String phoneNumber){
        for (Customer customer : customers){
            if(phoneNumber.equals(customer.getPhoneNumber())){
                return customer;
            }
        }
        return null;
    }

    // 기존의 전화번호로 등록된 고객이 있는지를 확인하는 메서드(중복)
    public boolean isPhoneNumberExist(String phoneNumber){
        for(Customer customer : customers){
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }
}

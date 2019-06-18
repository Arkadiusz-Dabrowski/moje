import {Injectable} from "@angular/core";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import {RegisterComponent} from "./register.component";

@Injectable()
export class RegisterModalService {
    private isOpen = false;
    constructor( private modalService: NgbModal){}

    open(stay?: boolean): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;
        const modalRef = this.modalService.open(RegisterComponent);
        modalRef.componentInstance.stay = stay;
        modalRef.result.then((result) => {
            this.isOpen = false;
        }, (reason) => {
            this.isOpen = false;
        });
        return modalRef;
    }
}

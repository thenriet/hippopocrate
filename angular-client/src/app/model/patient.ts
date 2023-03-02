export class Patient {
    id!: number;
    firstname!: string;
    lastname!: string;
    birthdate!: Date;
    address!: string;
    dateIn!: Date;
    dateOut!: Date|null|string;
    bedId!: number | null;
    roomId!: number;
    serviceId!: number;
    serviceName!: string;
    roomNumber!: number;
    bedNumber!: number;
}

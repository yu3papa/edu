import {CarPart} from "./car-part";

export const CARPARTS:CarPart[] = [
    {
        "id": 1,
        "name": "Super Tires",
        "description": "These tires are the very best",
        "price": 4.99,
        "inStock": 5,
        "image": "/images/tires.jpg",
        "featured": false,
        "quantity": 0
    },
    {
        "id": 2,
        "name": "Reinforced Shocks",
        "description": "Shocks made from kryptonite",
        "price": 9.99,
        "inStock": 4,
        "image": "/images/shocks.jpg",
        "featured": true,
        "quantity": 0
    },
    {
        "id": 3,
        "name": "Padded Seats",
        "description": "Super soft seats for a smooth ride",
        "price": 24.99,
        "inStock": 0,
        "image": "/images/seats.jpg",
        "featured": false,
        "quantity": 0
    }
];


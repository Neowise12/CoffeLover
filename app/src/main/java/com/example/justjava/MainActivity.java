            /**
             * IMPORTANT: Make sure you are using the correct package name.
             * This example uses the package name:
             * package com.example.android.justjava
             * If you get an error when copying this code into Android studio, update it to match teh package name found
             * in the project's AndroidManifest.xml file.
             **/

                package com.example.justjava;



                import android.annotation.SuppressLint;
                import android.content.Intent;
                import android.net.Uri;
                import android.os.Bundle;
                import androidx.appcompat.app.AppCompatActivity;

                import android.text.Editable;
                import android.view.View;
                import android.widget.CheckBox;
                import android.widget.EditText;
                import android.widget.TextView;
                import android.widget.Toast;

                import java.text.NumberFormat;
                import java.util.jar.Attributes;

            /**
                 * This app displays an order form to order coffee.
                 */
                public class MainActivity extends AppCompatActivity {
                    int quantity=2;
                    int toppingprice=0;

                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);
                    }

                    /**
                     * This method is called when the order button is clicked.
                     */
                    public void submitOrder(View view) {
                        CheckBox wippedcream = (CheckBox) findViewById(R.id.checkbox2);
                        Boolean haswippedcream = wippedcream.isChecked();
                        if(haswippedcream)
                            toppingprice=toppingprice+1;
                        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox3);
                        Boolean haschocolate = chocolate.isChecked();
                        if(haswippedcream)
                            toppingprice=toppingprice+2;
                        EditText name = (EditText) findViewById(R.id.editTextTextPersonName);
                        String value = name.getText().toString();
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for "+ value);
                        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(calculatePrice(), haswippedcream, haschocolate, value));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        }


                        /*
                         * This method displays the given quantity value on the screen.
                         *
                         * @param i
                         */
                        /*@SuppressLint("SetTextI18n")*/
                        @SuppressLint("SetTextI18n")
                        private void display ( int number){
                            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
    //                        if (quantity>0 && quantity<100)
                            quantityTextView.setText("" + number);
                        }
                        /**
                         * This method displays the given price on the screen.
                         *
                         */
                        /**
                         * This method displays the given text on the screen.
                         */
                        public void increment (View view){
                            if (quantity == 100) {
                                // Show an error message as a toast
                                Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
                                // Exit this method early because there's nothing left to do
                                return;
                            }
                            quantity = quantity + 1;
                            display(quantity);
                        }

                        public void decrement (View view){
                            if (quantity == 1) {
                                // Show an error message as a toast
                                Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
                                // Exit this method early because there's nothing left to do
                                return;
                            }
                            quantity = quantity - 1;
                            display(quantity);
                        }
                        private int calculatePrice () {
                            int price= (5+toppingprice)*quantity;
                            return price;
                        }
                        private String createOrderSummary ( int num, boolean wippedcream, boolean chocolate, String name ){

                            return getString(R.string.order_summary_name,name) + "\n" + "Add wipped cream?" + wippedcream + "\n" + "Add chocolate?" + chocolate + "\n" + "QUANTITY: " + quantity + "\n" + "TOTAL: $" + num + "\n" + getString(R.string.thank_your);
                        }


                }
//            19th video seee
package org.jesperancinha.jtd.jee.app1.domain;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jesperancinha.console.consolerizer8.Consolerizer;
import org.jesperancinha.console.consolerizer8.ConsolerizerColor;
import org.jesperancinha.jtd.jee.app1.Resources;
import org.jesperancinha.jtd.jee.app1.data.ArtistProducer;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.BRIGHT_CYAN;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.CYAN;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.GREEN;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ManagedBeanAlbumDaoTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Album.class, ManagedBeanAlbumDao.class, Resources.class, ArtistProducer.class, AlbumDao.class,
                        UserTransaction.class, EntityManager.class, Consolerizer.class, ConsolerizerColor.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }

    @Inject
    ManagedBeanAlbumDao managedBeanAlbumDao;

    @Test
    public void testCreateAlbum() {
        Album album = new Album();
        album.setAlbumName("Healing Is Difficult");
        album.setArtist("Sia");
        album.setYear(2001L);
        managedBeanAlbumDao.createAlbum(album);
        assertNotNull(album.getId());

        BRIGHT_CYAN.printGenericLn("TEST-> %s", album);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateAlbum_whenNullYear_throwException() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setYear(null);
        managedBeanAlbumDao.createAlbum(album);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateAlbum_whenEmailFail_throwException() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setEmail("Sia#wrongemail.com");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreateAlbum_whenSalesFail_throwException() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setSales("123.1234");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
    }

    @Test
    public void testCreateAlbum_whenSalesGood_dontThrow() {
        Album album = new Album();
        album.setAlbumName("OnlySee");
        album.setArtist("Sia");
        album.setSales("123.12");
        album.setYear(1997L);
        managedBeanAlbumDao.createAlbum(album);
        CYAN.printGenericLn("TEST-> %s", album);
    }

    @AfterClass
    public static void afterAll() {
        BLUE.printGenericTitleLn("After test ManagedBeanAlbumDaoTest");
        GREEN.printGenericLn("We see a lot of validations here in a layer above the database:");
        GREEN.printGenericLn("@Null, @NotNull, @Size, @Email and @Digits");
        GREEN.printGenericLn("@Null - Means explicitly that the member must be null");
        GREEN.printGenericLn("@NotNull - Means that the member cannot be null");
        GREEN.printGenericLn("@Size - Means that the member has to match validation in length");
        GREEN.printGenericLn("@Email - Means that the member has to have a conventional email form");
        GREEN.printGenericLn("@Digit - Is specific to numbers in a String form. It can be seen as an extension @Size");
        GREEN.printGenericLn(
                "More about @Digit: https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/Digits.html");
        GREEN.printGenericLn("BigDecimal\n" + "BigInteger\n" + "CharSequence\n"
                + "byte, short, int, long, and their respective wrapper types");
    }

}
